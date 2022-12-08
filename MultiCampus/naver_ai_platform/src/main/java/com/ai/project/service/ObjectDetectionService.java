package com.ai.project.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.project.model.ObjectVO;

@Service
public class ObjectDetectionService {
	@Autowired
	TranslateService transService;	
	
	public ArrayList<ObjectVO> objectDetect(String filePathName) {
		ArrayList<ObjectVO> obList = new ArrayList<ObjectVO>();
		
		String clientId = "yuk8q7vxmd"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "4oV1A3QTmd4fvjelyZdzmFGwPt0kQk2qxoj8T58a"; //애플리케이션 클라이언트 시크릿값";
        
        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = filePathName;
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision-obj/v1/detect"; // 객체 인식
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            // multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";
            // file 추가
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            BufferedReader br = null;
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
                
                // JSON 파싱 결과 받아오기
                obList = jsonToVOList(response.toString());
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return obList;
	}
	
	private ArrayList<ObjectVO> jsonToVOList(String jsonResultStr) {
		ArrayList<ObjectVO> obList = new ArrayList<ObjectVO>();
		
		JSONObject jsonObj = new JSONObject(jsonResultStr);
		JSONArray objArray = (JSONArray) jsonObj.get("predictions");
		JSONObject obj0 = objArray.getJSONObject(0);
		
		JSONArray nameArray = obj0.getJSONArray("detection_names");
		JSONArray boxArray = obj0.getJSONArray("detection_boxes");
		
		//int num = obj0.getInt("num_detections");
		
		for(int i=0; i<nameArray.length(); i++) {
			// name 추출
			//String name = translateToKor(nameArray.getString(i)); // 영어 이름 반환 -> 한글로 변환하는 메소드 호출하고 결과 받아옴
			String name = transService.translate(nameArray.getString(i)); // 다른 클래스(TranslateService)의 메소드 호출
			// 파파고 사용 : 한글 이름 받아와서 VO에 저장
			
			//x1, y1, x2, y2 추출
			JSONArray boxArr = boxArray.getJSONArray(i);
			double x1 = boxArr.getDouble(0);
			double y1 = boxArr.getDouble(1);
			double x2 = boxArr.getDouble(2);
			double y2 = boxArr.getDouble(3);
			
			//  VO에 저장
			ObjectVO vo = new ObjectVO();
			vo.setName(name);
			vo.setX1(x1);
			vo.setY1(y1);
			vo.setX2(x2);
			vo.setY2(y2);
			
			// 리스트에 추가
			obList.add(vo);
		}
		
		return obList;
	}
	
	// 메소드 추가 : translateToKor()
//	public String translateToKor(String name) {
//		String result = "";
//		
//		String clientId = "pszaahlydj";//애플리케이션 클라이언트 아이디값";
//        String clientSecret = "UXkkH1E22C7oMsDC2QXpWVYdR8U1VldhUVoTWiEj";//애플리케이션 클라이언트 시크릿값";
//        try {
//            String text = URLEncoder.encode(name, "UTF-8");
//            String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
//            URL url = new URL(apiURL);
//            HttpURLConnection con = (HttpURLConnection)url.openConnection();
//            con.setRequestMethod("POST");
//            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
//            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
//            // post request
//            String postParams = "source=en&target=ko&text=" + text;
//            con.setDoOutput(true);
//            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//            wr.writeBytes(postParams);
//            wr.flush();
//            wr.close();
//            int responseCode = con.getResponseCode();
//            BufferedReader br;
//            if(responseCode==200) { // 정상 호출
//                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            } else {  // 오류 발생
//                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
//            }
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = br.readLine()) != null) {
//                response.append(inputLine);
//            }
//            br.close();
//            System.out.println(response.toString()); // JSON 형태의 문자열로 반환
//            
//            // JSON 파싱 함수 호출하고 결과 받아옴
//            result = jsonToString(response.toString());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        	
//		return result;
//	}
	
	// 파파고에서 반환한 JSON 문자열 파싱 함수 : jsonToString()
//	public String jsonToString(String jsonResultStr) {
//		String result = "";
//		
//		JSONObject jsonObj = new JSONObject(jsonResultStr);
//		jsonObj = (JSONObject) jsonObj.get("message");
//		jsonObj = (JSONObject) jsonObj.get("result");
//		
//		result = jsonObj.getString("translatedText");
//		
//		return result;		
//	}
}






