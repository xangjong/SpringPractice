package com.ai.project.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {
	public String translate(String name) {
		String result = "";
		
		String clientId = "yuk8q7vxmd"; //애플리케이션 클라이언트 아이디값";
        String clientSecret = "4oV1A3QTmd4fvjelyZdzmFGwPt0kQk2qxoj8T58a"; //애플리케이션 클라이언트 시크릿값";
        
        try {
            String text = URLEncoder.encode(name, "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            // post request
            String postParams = "source=en&target=ko&text=" + text;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString()); // JSON 형태의 문자열로 반환
            
            // JSON 파싱 함수 호출하고 결과 받아옴
            result = jsonToString(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
        	
		return result;
	}
	
	// 파파고에서 반환한 JSON 문자열 파싱 함수 : jsonToString()
	public String jsonToString(String jsonResultStr) {
		String result = "";
		
		JSONObject jsonObj = new JSONObject(jsonResultStr);
		jsonObj = (JSONObject) jsonObj.get("message");
		jsonObj = (JSONObject) jsonObj.get("result");
		
		result = jsonObj.getString("translatedText");
		
		return result;		
	}
}
