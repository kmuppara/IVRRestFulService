package com.example.ivrrestfulservice.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ivrrestfulservice.vo.FileVO;

@Service
public interface IVRRestFulBO {
	
	public String uploadFile(FileVO fileVO) throws Exception;
	
	public FileVO fileDetails(String fileNm) throws Exception;
	
	public List<String> getFileNms() throws Exception;

}
