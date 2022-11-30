package com.ai.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ai.project.model.ObjectVO;
import com.ai.project.model.PoseVO;
import com.ai.project.service.ChatbotService;
import com.ai.project.service.OCRService;
import com.ai.project.service.ObjectDetectionService;
import com.ai.project.service.PoseEstimationService;
import com.ai.project.service.STTService;
import com.ai.project.service.STTService2;
import com.ai.project.service.TTSService;

@RestController
public class AIRestController {
	@Autowired
	PoseEstimationService poseService;
	
	@Autowired
	ObjectDetectionService objService;
	
	@Autowired
	OCRService ocrService;
	
	@Autowired 
	STTService sttService;
	
	@Autowired 
	STTService2 sttService2;
	
	@Autowired
	TTSService ttsService;
	
	@Autowired
	ChatbotService chtService;
	
	// 포즈 인식
	// 3. 파일 업로드하고 결과 받기
	@RequestMapping("/poseDetect")
	public ArrayList<PoseVO> poseDetect(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		
		// 1. 파일 저장 경로 설정 : 실제 서비스 되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "/Library/upload/";
		// 마지막에 / 있어야 함
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File newFile = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(newFile);		
		
		ArrayList<PoseVO> poseList = poseService.poseEstimate(filePathName);		
			
		return poseList;
	}
	
	// 객체 탐지
	// 3. 파일 업로드하고 결과 받기
	@RequestMapping("/objectDetect")
	public ArrayList<ObjectVO> objectDetect(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		
		// 1. 파일 저장 경로 설정 : 실제 서비스 되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "/Library/upload/";
		// 마지막에 / 있어야 함
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File newFile = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(newFile);		
		
		ArrayList<ObjectVO> objList = objService.objectDetect(filePathName);		
			
		return objList;
	}
	@RequestMapping("/OCRGeneral")
	public String ocr(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		String uploadPath = "/Library/upload/";
		
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		File newFile = new File(filePathName);
		
		file.transferTo(newFile);
		
		String result = ocrService.ocrGeneral(filePathName);
		
		return result;
	}
	
	
	@RequestMapping("/stt")
	public String stt(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		String uploadPath = "/Library/upload/";
		
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		File newFile = new File(filePathName);
		
		file.transferTo(newFile);
		
		String result = sttService.stt(filePathName);
		
		return result;
	}
	
	// 언어 선택
	@RequestMapping("/stt2")
	public String stt2(@RequestParam("uploadFile") MultipartFile file,
						@RequestParam("lang") String lang) throws IOException {
		String uploadPath = "/Library/upload/";
		
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		File newFile = new File(filePathName);
		
		file.transferTo(newFile);
		
		String result = sttService2.stt2(filePathName, lang);
		
		return result;
	}
	
	// TTS
	// 3. 파일 업로드하고 결과 받기
	@RequestMapping("/tts")
	public String ttsDetect(@RequestParam("uploadFile") MultipartFile file) throws IOException {
			
		// 1. 파일 저장 경로 설정 : 실제 서비스 되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "/Library/upload/";
		// 마지막에 / 있어야 함
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File newFile = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(newFile);
		
		String voiceFileName = ttsService.tts(filePathName);
		
		return voiceFileName;
	}
			
	// TTS
	// 3. 파일 업로드하고 결과 받기
	@RequestMapping("/tts2")
	public String ttsDetect(@RequestParam("uploadFile") MultipartFile file,
							@RequestParam("lang") String lang) throws IOException {
				
		// 1. 파일 저장 경로 설정 : 실제 서비스 되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "/Library/upload/";
		// 마지막에 / 있어야 함
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File newFile = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(newFile);
		
		String audioFileName = ttsService.tts2(filePathName, lang);
		
		return audioFileName;
	}
	
	
	// TTS
	// 3. 파일 업로드하고 결과 받기
	@RequestMapping("/tts3")
	public HashMap<String, Object> ttsDetect3(@RequestParam("uploadFile") MultipartFile file,
							@RequestParam("lang") String lang) throws IOException {
				
		// 1. 파일 저장 경로 설정 : 실제 서비스 되는 위치 (프로젝트 외부에 저장)
		String uploadPath = "/Library/upload/";
		// 마지막에 / 있어야 함
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File newFile = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(newFile);
		
		HashMap<String, Object> audioFileName = ttsService.tts3(filePathName, lang);
		
		return audioFileName;
	}
	
	
	// Chatbot Service
	@RequestMapping("/chatResult")
	public String chatResult(@RequestParam("message") String message) throws IOException {
		return ChatbotService.main(message);
	}
	
	@RequestMapping("/chatbotTTS")
	public String chatbotTTS(@RequestParam String message) {
		return ttsService.chatbotTTS(message);
	}
	
	
}
