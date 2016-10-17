package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploader {

	private static final String FOLDER = "img";
	private static FileUploader fileUploader;
	
	private FileUploader() {
		
	}
	
	public static FileUploader getFileUploader() {
		if (fileUploader == null) {
			fileUploader = new FileUploader();
		}
		return fileUploader;
	}
	
	// Return img URL
	public ArrayList<String> upload(ServletContext servletContext, HttpServletRequest request, String type, int id, List<FileItem> fileItems) {
		
		ArrayList<String> imgUrls = new ArrayList<>();
		
		// Check if the upload file exists
		if (ServletFileUpload.isMultipartContent(request)) {
			
			// Create temp file
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(10240);
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
			
			ServletFileUpload upload = new ServletFileUpload();
			upload.setFileItemFactory(factory);

			try {
				if (fileItems != null) {
					// Create director if not exist
					String dirPath = servletContext.getRealPath(File.separator + FOLDER + File.separator + type + id);
					File directory = new File(dirPath);
					if (!directory.exists()) {
						directory.mkdir();
					}
					
					// Store files
					for (FileItem fileItem : fileItems) {
						if (!fileItem.isFormField()) {
							// Store image file
							String fileName = new File(fileItem.getName()).getName();
							String storeFilePath = directory + File.separator + fileName;
							File storeFile = new File(storeFilePath);
							fileItem.write(storeFile);
							
							// Format image URL for return
							String imgUrl = request.getServerName() + ":" + request.getServerPort() + servletContext.getContextPath() + "/" + FOLDER + "/" + type + id + "/" + fileName;
							imgUrls.add(imgUrl);
							
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return imgUrls;
	}
}
