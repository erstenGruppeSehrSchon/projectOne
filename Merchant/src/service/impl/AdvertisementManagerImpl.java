package service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import common.util.FileUploader;
import dao.AdvertisementDao;
import po.Advertisement;
import service.AdvertisementManager;

@Service
public class AdvertisementManagerImpl implements AdvertisementManager {

	@Autowired
	AdvertisementDao dao;
	
	@Override
	public List<Advertisement> getAdvertisementBySid(String sid) {
		return dao.getAdvertisementBySid(sid);
	}
	
	@Override
	public Advertisement addAdvertisement(String sid, List<MultipartFile> files, ServletContext context) {
		ArrayList<String> imgPaths = new ArrayList<>();
		imgPaths.add("test.jpg");
		if (files != null) {
			FileUploader uploader = FileUploader.getFileUploader();
			imgPaths = uploader.upload(files, context);
		}
		
		// Create advertisement
		Advertisement advertisement = new Advertisement();
		advertisement.setImgPath(imgPaths.get(0));
		advertisement.setStatus(Advertisement.INIT_STATUS);
		advertisement.setCreatedTime(new Date());
		
		return dao.addAdvertisement(sid, advertisement);
	}

	@Override
	public void updateAdvertisementStatus(String sid,String status){
		dao.updateAdvertisementStatus(sid, status);
	}


}
