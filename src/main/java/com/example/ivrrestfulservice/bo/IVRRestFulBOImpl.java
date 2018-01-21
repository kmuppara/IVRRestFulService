package com.example.ivrrestfulservice.bo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.springframework.stereotype.Service;

import com.example.ivrrestfulservice.vo.FileVO;

@Service
public class IVRRestFulBOImpl implements IVRRestFulBO {

	@Override
	public String uploadFile(FileVO fileVO) throws Exception {
		FileInputStream input = new FileInputStream(fileVO.getFile());
		FileOutputStream output = null;
		File folder = new File("C:\\IVRRepo");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		output = new FileOutputStream(new File(folder, fileVO.getFileNm()));
		int bytesRead = 0;
		byte[] buffer = new byte[4096];
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}
		input.close();
		if (output != null) {
			output.close();
		}
		return "UPLOADED";
	}

	@Override
	public FileVO fileDetails(String fileNm) throws Exception {
		FileVO fileVO = new FileVO();
		fileNm = fileNm.contains(".mp3") ? fileNm : fileNm + ".mp3";
		File file = new File("C:\\IVRRepo\\" + fileNm);
		AudioFile audiofile = AudioFileIO.read(file);
		fileVO.setDuration(audiofile.getAudioHeader().getTrackLength());
		fileVO.setSize(file.length());
		fileVO.setFileNm(fileNm);
		return fileVO;
	}

	@Override
	public List<String> getFileNms() throws Exception {
		List<String> fileNms = new ArrayList<String>();
		File folder = new File("C:\\IVRRepo");
		for (File fileEntry : folder.listFiles()) {
			String name = fileEntry.getName();
			if (name.substring(name.length() - 3, name.length()).equals("mp3")) {
				fileNms.add(name);
			} else {
				continue;
			}
		}
		return fileNms;
	}

}
