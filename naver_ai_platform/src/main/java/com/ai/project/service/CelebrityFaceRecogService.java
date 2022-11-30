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
import org.springframework.stereotype.Service;

import com.ai.project.model.CelebrityVO;

@Service
public class CelebrityFaceRecogService {
	public ArrayList<CelebrityVO> celebrityFaceRecog(String filePathName) {
		// 자바 API 코드 복사해서 붙여 넣기
		
		String clientId = "yuk8q7vxmd"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "4oV1A3QTmd4fvjelyZdzmFGwPt0kQk2qxoj8T58a"; //애플리케이션 클라이언트 시크릿값";
        
        ArrayList<CelebrityVO> celList = new ArrayList<CelebrityVO>();

        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            //String imgFile = "C:/images/yun.jpg";
            String imgFile = filePathName;
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity"; // 유명인 얼굴 인식
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
                System.out.println(response.toString()); // API 호출 결과 반환값을 콘솔에 출력 
                
                // JSON 파싱 메소드 호출 : JSON 형식의 문자열 전달하고  VO 리스트 받음
                celList = jsonToVOList(response.toString());
            } 
//            else {
//                System.out.println("error !!!");
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return celList;
	}
	
	// JSON 파싱 메소드
	public ArrayList<CelebrityVO>  jsonToVOList(String jsonResultStr){
		ArrayList<CelebrityVO> celList = new ArrayList<CelebrityVO>();
		
		// JSON  형태의 문자열에서 JSON 오브젝트 "faces" 추출해서 JSONArray에 저장
		JSONObject jsonObj = new JSONObject(jsonResultStr);
		JSONArray celArray = (JSONArray) jsonObj.get("faces");
		
		// JSONArray의 각 요소에 value와 confidence 추출하여 VO 담고, 리스트에 추가
		if(celArray != null) {
			
			for(int i=0; i < celArray.length(); i++) {
				JSONObject tempObj =celArray.getJSONObject(i);
				tempObj =(JSONObject) tempObj.get("celebrity");
				
				// value와 confidence 추출 / 저장
				String value = (String) tempObj.get("value");
				double confidence = Double.parseDouble(String.valueOf(tempObj.get("confidence")));
				
				// VO에 저장
				CelebrityVO vo = new CelebrityVO();
				vo.setValue(value);
				vo.setConfidence(confidence);
				
				// 리스트에 추가
				celList.add(vo);				
			}
			
		} else {
			CelebrityVO vo = new CelebrityVO();
			vo.setValue("없음");
			vo.setConfidence(0);
		}		
		
		 return celList;
	}
}















