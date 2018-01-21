package com.example.ivrrestfulservice.vo;

import java.io.File;
import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class FileVO implements Serializable {
	
	private File file;
	private int duration;
	private long size;
	private String fileNm;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getFileNm() {
		return fileNm;
	}
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}


}
