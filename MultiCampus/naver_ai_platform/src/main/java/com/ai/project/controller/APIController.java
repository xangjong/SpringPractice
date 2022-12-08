package com.ai.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ai.project.model.CelebrityVO;
import com.ai.project.model.FaceVO;
import com.ai.project.service.CelebrityFaceRecogService;
import com.ai.project.service.ChatbotService;
import com.ai.project.service.FaceRecogService;
import com.ai.project.service.OCRService;
import com.ai.project.service.ObjectDetectionService;
import com.ai.project.service.PoseEstimationService;
import com.ai.project.service.STTService;
import com.ai.project.service.TTSService;

@Controller 
public class APIController {
	@Autowired
	CelebrityFaceRecogService cfrService;
	
	@Autowired
	FaceRecogService frService;
	
	@Autowired
	PoseEstimationService poseService;
	
	@Autowired
	ObjectDetectionService objService;
	
	@Autowired
	OCRService ocrService;
	
	@Autowired 
	STTService sttService;
	
	@Autowired 
	TTSService ttsService;
	
	@Autowired
	ChatbotService chtService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	// (1) 유명인 얼굴 인식 API 호출 결과를 콘솔에 출력
//	@RequestMapping("/celFaceRecg")
//	public void celFaceRecg() {
//		cfrService.celebrityFaceRecog();
//	}
	
	// (2) 유명인 얼굴 인식 API 호출 결과 JSON 파싱
	//  VO 리스트 받아서 Model 담아서  celebrityResult.jsp에 전달
//	@RequestMapping("/celFaceRecg")
//	public String celFaceRecg(Model model) {
//		 ArrayList<CelebrityVO> celList = cfrService.celebrityFaceRecog();
//		
//		// Model에 저장
//		 model.addAttribute("celList", celList);
//		
//		return "celebrityResult";
//	}
	
	@RequestMapping("/celFaceRecgForm")
	public String celFaceRecgForm() {
		return "celebrityResult";
	}
	
	// (3) 파일 업로드하고 결과 받기
	@RequestMapping("/celFaceRecg")
	public String celFaceRecg(@RequestParam("uploadFile") MultipartFile file,
			 Model model) throws IOException {
		
		// 1. 파일 저장 경로 설정 : 실제 서비스 되는 위치(프로젝트 외부에 저장)
		String uploadPath = "/Library/upload/";
		// c:대소문자 상관없으며 마지막에 '/' 있어야 한다
		
		// 2. 원본 파일 이름 설정
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File newFile = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(newFile);
		
		 ArrayList<CelebrityVO> celList = cfrService.celebrityFaceRecog(filePathName);
		
		// Model에 저장
		 model.addAttribute("celList", celList);
		 model.addAttribute("fileName", originalFileName);
		
		return "celebrityResult";
	}
	
	// 얼굴 감지
	//(1) 결과를 콘솔에 출력
//	@RequestMapping("/faceRecog")
//	public String faceRecog() {
//		frService.faceRecog();
//		return "faceRecogResult";
//	}
	
	// (2) 유명인 얼굴 인식 API 호출 결과를 콘솔에 출력 
		// VO 리스트 받아서 Model 담아서 celebrityResult.jsp 에 전달
//		@RequestMapping("/faceRecog") 
//		public String celFaceRecog(Model model) {
//			ArrayList<FaceVO> celList = frService.faceRecog();
//			
//			// Model에 저장 
//			model.addAttribute("celList", celList);
//			
//			return "faceRecogResult";
//		}
	
	@RequestMapping("/faceRecogForm")
	public String formFace() {
		return "faceRecogResult";
	}
	
	// 3. 파일 업로드하고 결과 받기
	@RequestMapping("/faceRecog")
	public String viewFaceRecog(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException {
		
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
		
		ArrayList<FaceVO> faceList = frService.faceRecog(filePathName);
		
		// Model에 저장
		model.addAttribute("faceList", faceList);
		model.addAttribute("fileName", originalFileName);
		
		return "faceRecogResult";
	}
	
	// 포즈 인식
	// (1) 결과를 콘솔창에 출력
	@RequestMapping("/poseEstimateForm") 
	public String poseEstimate() {		
		return "poseResult";
	}
	
	// 객체 탐지
	// (1) 기본 (API 호출 결과 확인)
	@RequestMapping("/objectDetectForm")
	public String objectDetect() {
		return "objectResult";
	}
	
	// OCR 광학 문자 인식 예제
	// (1) 결과를 콘솔에 출력
	@RequestMapping("/OCRForm")
	public String OCRGeneral() {
		return "ocrResult";
	}
	
	@RequestMapping("/OCRTemplate")
	public void OCRTemplate() {
		ocrService.ocrTemplate();
	}
	
	@RequestMapping("/sttForm")
	public String stt() {
		return "sttResult";
	}
	
	@RequestMapping("/sttForm2")
	public String stt2() {
		return "sttResult2";
	}
	
	@RequestMapping("/ttsForm")
	public String ttsForm() {
		return "ttsResult";
	}
	
	@RequestMapping("/ttsForm2")
	public String ttsForm2() {
		return "ttsResult2";
	}
	
	@RequestMapping("/ttsForm3")
	public String ttsForm3() {
		return "ttsResult3";
	}
	
	
	@RequestMapping("/chatbotForm")
	public String chatbotForm() {
		return "chatbotForm";
	}
	
	@RequestMapping("/chatbotForm2")
	public String chatbotForm2() {
		return "chatbotForm2";
	}
	
	@RequestMapping("/chatbotFormJSON")
	public String chatbotFormJSON() {
		return "chatbotFormJSON";
	}
	
	// 음성 녹음 테스트 : voiceRecord
	@RequestMapping("/voiceRecord")
	public String voiceRecord() {
		return "voiceRecordTest";
	}
}










