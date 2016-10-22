package common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUploader {

	private static final String UPLOAD_DIR = "img";
	private static FileUploader fileUploader;
	
	private FileUploader() {
		
	}
	
	public static FileUploader getFileUploader() {
		if (fileUploader == null) {
			fileUploader = new FileUploader();
		}
		return fileUploader;
	}
	
	// Return file paths
	public ArrayList<String> upload(List<MultipartFile> files) {
		ArrayList<String> imgPaths = new ArrayList<>();
			
		for (MultipartFile file : files) {
			// Format file path
			String fileName = file.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			String resultFileName = new Date().getTime() + UUID.randomUUID().toString() + fileType;
			String filePath = UPLOAD_DIR + resultFileName;
			
			// Store file
			File resultFile = new File(filePath);
			try {
				file.transferTo(resultFile);
				
				// Add to list
				imgPaths.add(filePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return imgPaths;
	}
}
