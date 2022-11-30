package com.spring_boot_mybatis.project.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDonwloadController {
	
	// 파일 목록 보여주기
	@RequestMapping("/fileDownloadList")
	public ModelAndView fileDownloadList(ModelAndView mv) {
		File path = new File("/Library/springWorkspace/upload/");
		String[] fileList = path.list();
		
		mv.addObject("fileList", fileList);
		mv.setViewName("upload/fileDownloadListView");
		
		return mv;
	}
	
	// 파일 다운로드 
	@RequestMapping("/fileDownload/{file}")
	public void fileDownload(@PathVariable String file, 
								HttpServletResponse response) throws IOException {
		
		File f = new File("/Library/springWorkspace/upload/", file);
		// 파일명 인코딩
		String encodedFileName = new String (file.getBytes("UTF-8"), "ISO-8859-1");

		
		// file 다운로드 설정
		
		response.setContentType("application/download");
		response.setContentLength((int)f.length());
		response.setHeader("Content-Disposition", "attatchment;filename=\"" + encodedFileName + "\"");
		
		// 다운로드 시 저장되는 이름은 Response Header의 "Content-Disposition"에 명시
		
		OutputStream os = response.getOutputStream();
		
		FileInputStream fis = new FileInputStream(f);
		FileCopyUtils.copy(fis, os);
		
		// fis.close();
		// os.close();
		
	}
}
