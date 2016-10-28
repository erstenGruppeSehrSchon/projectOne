package common.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.web.multipart.MultipartFile;

public class FileUploader {

	private static final String UPLOAD_DIR = "/uploadImg/";
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
	public ArrayList<String> upload(List<MultipartFile> files, ServletContext context) {
		ArrayList<String> imgPaths = new ArrayList<>();
			
		for (MultipartFile file : files) {
			// Format file path
			String fileName = file.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			String resultFileName = new Date().getTime() + UUID.randomUUID().toString() + fileType;
			String filePath = context.getRealPath(UPLOAD_DIR + resultFileName);
						
			// Store file
			File resultFile = new File(filePath);
			try {
				file.transferTo(resultFile);
				
				// Add to list
				imgPaths.add("http://cheunan-w7:8081" + context.getContextPath() + UPLOAD_DIR + resultFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return imgPaths;
	}
}
