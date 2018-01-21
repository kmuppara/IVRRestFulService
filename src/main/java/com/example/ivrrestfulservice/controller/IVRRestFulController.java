package com.example.ivrrestfulservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ivrrestfulservice.bo.IVRRestFulBO;
import com.example.ivrrestfulservice.vo.FileVO;

@RestController
@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
public class IVRRestFulController {
	
	@Autowired
	IVRRestFulBO ivrRestFulBO;
	
	@RequestMapping(value="/ivrservice",method=RequestMethod.POST)
	public ResponseEntity<?> uploadFile(@RequestBody FileVO fileVO) throws Exception{
		ivrRestFulBO.uploadFile(fileVO);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/ivrservice/{fileNm}",method=RequestMethod.GET)
	public ResponseEntity<?> fileDetails(@PathVariable("fileNm") String fileNm) throws Exception{
		FileVO file = new FileVO();
		file = ivrRestFulBO.fileDetails(fileNm);
		return ResponseEntity.status(HttpStatus.OK).body(file);
	}
	
	@RequestMapping(value="/ivrservice/ivrfiles", method=RequestMethod.GET)
	public ResponseEntity<?> filesList() throws Exception{
		List<String> fileNms = new ArrayList<String>();
		fileNms = ivrRestFulBO.getFileNms();
		return ResponseEntity.status(HttpStatus.OK).body(fileNms);
	}

}
