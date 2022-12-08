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

import com.ai.project.model.FaceVO;

@Service
public class FaceRecogService {
	public ArrayList<FaceVO> faceRecog(String filePathName) {
		ArrayList<FaceVO> faceList = new ArrayList<FaceVO>();
		
		String clientId = "yuk8q7vxmd"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "4oV1A3QTmd4fvjelyZdzmFGwPt0kQk2qxoj8T58a"; //애플리케이션 클라이언트 시크릿값";

        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            //String imgFile = "C:/images/family.jpg";
            String imgFile = filePathName;
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/face"; // 얼굴 감지
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
                System.out.println(response.toString());  // 결과를 콘솔에 출력
                
                // JSON 파싱 메소드 호출 : JSON 형식의 문자열 전달하고 VO 리스트 받음
                faceList = jsonToVOList(response.toString());
            } 
            
//            else {
//                System.out.println("error !!!");
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return faceList;
	}
	
	// JSON 파싱 메소드
	public ArrayList<FaceVO>  jsonToVOList(String jsonResultStr){
		ArrayList<FaceVO> celList = new ArrayList<FaceVO>();
		
		// JSON  형태의 문자열에서 JSON 오브젝트 "faces" 추출해서 JSONArray에 저장
		JSONObject jsonObj = new JSONObject(jsonResultStr);
		JSONArray celArray = (JSONArray) jsonObj.get("faces");			
		
		// JSONArray의 각 요소에 value와 confidence 추출하여 VO 담고, 리스트에 추가
		if(celArray != null) {
			
			for(int i = 0; i < celArray.length(); i++) {
				JSONObject tempObj = celArray.getJSONObject(i); // gender, age, emotion, pose 용
				FaceVO vo = new FaceVO();
				String value = "";
				double confidence = 0;
				
				JSONObject obj = null; // value, confidence 용 
				
				// 1. 성별
				obj = (JSONObject)tempObj.get("gender");
				
				// value와 confidence 추출 / 저장
				value = (String)obj.get("value");
				confidence = Double.parseDouble(String.valueOf(obj.get("confidence")));
				
				// VO에 저장				
				vo.setGenderValue(value);
				vo.setGenderConfidence(confidence);
				
				// 2. 나이
				obj = (JSONObject)tempObj.get("age");
				
				// value와 confidence 추출 / 저장
				value = (String)obj.get("value");
				confidence = Double.parseDouble(String.valueOf(obj.get("confidence")));
				
				// VO에 저장
				vo.setAgeValue(value);
				vo.setAgeConfidence(confidence);
				
				// 3. 감정
				obj = (JSONObject)tempObj.get("emotion");
				
				// value와 confidence 추출 / 저장
				value = (String)obj.get("value");
				confidence = Double.parseDouble(String.valueOf(obj.get("confidence")));
				
				// VO에 저장
				vo.setEmotionValue(value);
				vo.setEmotionConfidence(confidence);
				
				// 4. 포즈
				obj = (JSONObject)tempObj.get("pose");
				
				// value와 confidence 추출 / 저장
				value = (String)obj.get("value");
				confidence = Double.parseDouble(String.valueOf(obj.get("confidence")));
				
				// VO에 저장
				vo.setPoseValue(value);
				vo.setPoseConfidence(confidence);
				
				// 리스트에 추가
				celList.add(vo);				
			}
			
		} else {
			FaceVO vo = new FaceVO();
			vo.setGenderValue("없음");
			vo.setGenderConfidence(0);
			
			vo.setAgeValue("없음");
			vo.setAgeConfidence(0);
			
			vo.setEmotionValue("없음");
			vo.setEmotionConfidence(0);
			
			vo.setPoseValue("없음");
			vo.setPoseConfidence(0);
		}
		
		 return celList;
	}	
	
	
	
	
	// JSON 파싱 메소드
//	public ArrayList<FaceVO> jsonToVOList(String jsonResultStr){
//		ArrayList<FaceVO> faceList = new ArrayList<FaceVO>();
//		
//		JSONObject jsonObj = new JSONObject(jsonResultStr);
//		JSONArray faceArray = (JSONArray) jsonObj.get("faces");
//		
//		// JSONArray의 각 요소에 value와 confidence 추출하여 VO에 담고, 리스트에 추가
//		if(faceArray != null) {
//			
//			for (int i = 0; i < faceArray.length(); i++) {
//				JSONObject faceObj = faceArray.getJSONObject(i);
//				
//				JSONObject genderObj = (JSONObject) faceObj.get("gender");
//				JSONObject ageObj = (JSONObject) faceObj.get("age");
//				JSONObject emotionObj = (JSONObject) faceObj.get("emotion");
//				JSONObject poseObj = (JSONObject) faceObj.get("pose");
//				
//				// value와 confidence 추출 / 저장
//				String genderValue = (String) genderObj.get("value");
//				double genderConfidence = Double.parseDouble(String.valueOf(genderObj.get("confidence")));
//				
//				String ageValue = (String) ageObj.get("value");
//				double ageConfidence = Double.parseDouble(String.valueOf(ageObj.get("confidence")));
//				
//				String emotionValue = (String) emotionObj.get("value");
//				double emotionConfidence = Double.parseDouble(String.valueOf(emotionObj.get("confidence")));
//				
//				String poseValue = (String) poseObj.get("value");
//				double poseConfidence = Double.parseDouble(String.valueOf(poseObj.get("confidence")));
//				
//				// VO에 저장
//				FaceVO vo = new FaceVO();
//				vo.setGenderValue(genderValue);
//				vo.setGenderConfidence(genderConfidence);
//				vo.setAgeValue(ageValue);
//				vo.setAgeConfidence(ageConfidence);
//				vo.setEmotionValue(emotionValue);
//				vo.setEmotionConfidence(emotionConfidence);
//				vo.setPoseValue(poseValue);
//				vo.setPoseConfidence(poseConfidence);
//				
//				// 리스트에 추가
//				faceList.add(vo);
//			}
//		}else {
//			// VO에 저장
//			FaceVO vo = new FaceVO();
//			vo.setGenderValue("없음");
//			vo.setGenderConfidence(0);
//			vo.setAgeValue("없음");
//			vo.setAgeConfidence(0);
//			vo.setEmotionValue("없음");
//			vo.setEmotionConfidence(0);
//			vo.setPoseValue("없음");
//			vo.setPoseConfidence(0);
//		}
//		
//		
//		return faceList;
//	}
}











