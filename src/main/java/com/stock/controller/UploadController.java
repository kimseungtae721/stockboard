package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.stock.domain.NoticesFileUploadVo;
import com.stock.service.FileUploadService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@Autowired
	private FileUploadService fileUpload;
	
	@ResponseBody
	@PostMapping(value="/uploadAjax")
	public NoticesFileUploadVo uploadFile(@RequestParam("file")MultipartFile multipartfile) {
		
		log.info("controller---" + multipartfile.getOriginalFilename());
		
//		log.info(fileUpload.uploadFile(multipartfile));
		
		return fileUpload.uploadFile(multipartfile);
	
//		File file = new File("test");
//		
//		System.out.println("절대경로---" + file.getAbsolutePath());
//		
//		String path = UploadController.class.getResource("").getPath();
//		
//		log.info("2경로--" + path);
	}
	
}