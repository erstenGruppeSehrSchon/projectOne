package service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import po.Advertisement;


public interface AdvertisementManager {

	public List<Advertisement> getAdvertisementBySid(String sid);
	public Advertisement addAdvertisement(String sid, List<MultipartFile> files, ServletContext context);
	public void updateAdvertisementStatus(String sid,String status);
	
}
