package com.ai.project.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class OCRService {
	public String ocrGeneral(String filePathName) {
		String apiURL = "https://5knsg9jnjg.apigw.ntruss.com/custom/v1/17423/9a78ad932450fa5f884f025cfbb0df24faf7ffdc0609403ec0ed22fa5ef48789/general";
		String secretKey = "RUZGVkdkbFFZaFJTdGdFcXRCVmtleElWbXdPUkhsZmM=";
		
		String result = "";
		String imageFile = filePathName;

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			String postParams = json.toString();

			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(imageFile);
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

			System.out.println(response);
			
			// JSON 파싱 메소드 호출 : JSON 형식의 문자열 전달하고 VO 리스트 받음
			result = jsonToString(response.toString());
			
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
		IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("--").append(boundary).append("\r\n");
		sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
		sb.append(jsonMessage);
		sb.append("\r\n");
	
		out.write(sb.toString().getBytes("UTF-8"));
		out.flush();
	
		if (file != null && file.isFile()) {
			out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
			StringBuilder fileString = new StringBuilder();
			fileString
				.append("Content-Disposition:form-data; name=\"file\"; filename=");
			fileString.append("\"" + file.getName() + "\"\r\n");
			fileString.append("Content-Type: application/octet-stream\r\n\r\n");
			out.write(fileString.toString().getBytes("UTF-8"));
			out.flush();
	
			try (FileInputStream fis = new FileInputStream(file)) {
				byte[] buffer = new byte[8192];
				int count;
				while ((count = fis.read(buffer)) != -1) {
					out.write(buffer, 0, count);
				}
				out.write("\r\n".getBytes());
			}
	
			out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
		}
	out.flush();
}
	public void ocrTemplate() {
		
		// String apiURL = "https://5knsg9jnjg.apigw.ntruss.com/custom/v1/17446/fcf19ff1624c817b82e709f09fef582045b16bce4fdbe645301bd3789467b435/infer";
		// String secretKey = "eUlGd1dXcEhhaE54YWd1QWdaTnFiTVhLak1PTlNVTGQ=";
		
		String apiURL = "https://7msfu06pyd.apigw.ntruss.com/custom/v1/17447/bd6adcfcae548107babc5086535ce344604eadbb9ee19157df43c8fb893e28fc/infer"; 
		String secretKey = "TGh2WFpJR2t6a2poQ0lNWG9WZkpqbWZFQkZCakVEdGk=";
		
		String result = "";
		String imageFile = "/Library/images/receipt.jpg";

		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setUseCaches(false);
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setReadTimeout(30000);
			con.setRequestMethod("POST");
			String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
			con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			con.setRequestProperty("X-OCR-SECRET", secretKey);

			JSONObject json = new JSONObject();
			json.put("version", "V2");
			json.put("requestId", UUID.randomUUID().toString());
			json.put("timestamp", System.currentTimeMillis());
			JSONObject image = new JSONObject();
			image.put("format", "jpg");
			image.put("name", "demo");
			JSONArray images = new JSONArray();
			images.put(image);
			json.put("images", images);
			String postParams = json.toString();

			con.connect();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			long start = System.currentTimeMillis();
			File file = new File(imageFile);
			writeMultiPart(wr, postParams, file, boundary);
			wr.close();

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();

			System.out.println(response); // 결과 출력		
			
			
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e);
		}		

	}
	// JSON 문자열 파싱 
	public String jsonToString(String jsonResultStr) {
		
		String inferText = "";
		JSONObject jsonObj = new JSONObject(jsonResultStr);
		JSONArray imagesArray = (JSONArray) jsonObj.get("images");
		
		jsonObj = imagesArray.getJSONObject(0);
		JSONArray fieldsArray = (JSONArray) jsonObj.get("fields");
		
		for(int i = 0; i < fieldsArray.length(); i++) {
			JSONObject fieldsObj = fieldsArray.getJSONObject(i);
			inferText += fieldsObj.getString("inferText") + " ";
		}
		
		return inferText;
	}
	
	// JSON 파싱 메소드
//	public String jsonToString2(String jsonResultStr){
//		String result = "";
//		
//		// JSON  형태의 문자열에서 JSON 오브젝트 "faces" 추출해서 JSONArray에 저장
//		JSONArray jsonObj = new JSONObject(jsonResultStr).getJSONArray("images");
//		JSONArray fieldObj =  jsonObj.getJSONObject(0).getJSONArray("fields");
//		
//		for(int i = 0; i < fieldObj.length(); i++) {
//			result += fieldObj.getJSONObject(i).getString("inferText") + " ";
//		}
//		System.out.println(result);
//		return result;
//	}
}













