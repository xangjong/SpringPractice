package com.ai.project.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class STTService {
	public String stt(String filePathName) {
		
		String result="";
		
		String clientId = "yuk8q7vxmd"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "4oV1A3QTmd4fvjelyZdzmFGwPt0kQk2qxoj8T58a"; //애플리케이션 클라이언트 시크릿값";
        
	        try {
	            String imgFile = filePathName;
	            File voiceFile = new File(imgFile);

	            String language = "Kor";  // 언어 코드 ( Kor, Jpn, Eng, Chn )
	            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
	            URL url = new URL(apiURL);

	            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	            conn.setUseCaches(false);
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            conn.setRequestProperty("Content-Type", "application/octet-stream");
	            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

	            OutputStream outputStream = conn.getOutputStream();
	            FileInputStream inputStream = new FileInputStream(voiceFile);
	            byte[] buffer = new byte[4096];
	            int bytesRead = -1;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }
	            outputStream.flush();
	            inputStream.close();
	            BufferedReader br = null;
	            int responseCode = conn.getResponseCode();
	            if(responseCode == 200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            } else {  // 오류 발생
	                System.out.println("error!!!!!!! responseCode= " + responseCode);
	                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            }
	            String inputLine;

	            if(br != null) {
	                StringBuffer response = new StringBuffer();
	                while ((inputLine = br.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                br.close();
	                System.out.println(response.toString()); // 반환된 결과 텍스트
	                result = jsonToString(response.toString());
	                
	                // 결과를 파일로 저장
	                resultToFileSave(result);
	            } else {
	                System.out.println("error !!!");
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return result;
		
	}
	
	
	// JSON 파싱 메소드
	public String jsonToString(String jsonResultStr) {
		
		String result = new JSONObject(jsonResultStr).getString("text");
		
		return result;
	}
	
	// 결과 텍스트를 파일로 저장
	
	public void resultToFileSave(String result) {
		
		// 저장할 파일명 생성
		String fileName = Long.valueOf(new Date().getTime()).toString();
		try {
			OutputStream os = new FileOutputStream("/Library/upload/" + "stt_" + fileName + ".txt");
			byte[] bytes = result.getBytes();
			os.write(bytes);
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	// 결과 텍스트를 파일로 저장2 : FileWriter 사용
	public void resultToFileSave2(String result) {
		
		
		try {
			// 저장할 파일명 생성
			String fileName = Long.valueOf(new Date().getTime()).toString();
			String filePath = "/Library/upload/" + "stt_" + fileName + ".txt";
			FileWriter fw = new FileWriter(filePath);
			fw.write(result);
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
}