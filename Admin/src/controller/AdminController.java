package controller;

import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import po.Admin;
import po.Advertisement;
import po.Merchant;
import service.AdminManager;
import service.AdvertisementManager;
import service.MerchantManager;

@Controller
@SessionAttributes("admin")
public class AdminController {
	
	@Autowired
	private AdminManager adminManager;
	
	@Autowired
	private MerchantManager merchantManager;
	
	@Autowired
	private AdvertisementManager advertisementManager;
	
	@RequestMapping(value="login", method={RequestMethod.POST})
	public ModelAndView login(String username, String password) {
		
		System.out.println(username + "..." + password);
		
        ModelAndView modelAndView = new ModelAndView();
        
        // Check admin existence
        Admin admin = adminManager.login(username, password);
        
        // Set admin object (null if fail)
        if (admin == null) {
        	System.out.println("admin is null");
        	modelAndView.setViewName("login");
        } else {
        	// Set view
            modelAndView.setViewName("index");
            modelAndView.addObject("admin", admin);
            modelAndView.addObject("aMerchants", merchantManager.getMerchantByStatus("Pending"));
        }
        
		return modelAndView;
	}
	
	@RequestMapping(value="getMerchantByMid", method={RequestMethod.GET})
	@ResponseBody
	public Merchant getMerchant(String mid) {
		return merchantManager.getMerchantByMid(mid);
	}
	
	@RequestMapping(value="getAllMerchants", method={RequestMethod.GET})
	@ResponseBody
	public List<Merchant> getAllMerchants() {
		return merchantManager.getAllMerchants();
	}
	
	@RequestMapping(value="getMerchantsByCriteria", method={RequestMethod.GET})
	@ResponseBody
	public List<Merchant> getMerchantsByCriteria(String mid, String name, String gender, Integer ageIndex, String regDate, String status) {
		return merchantManager.getMerchantsByCriteria(mid, name, gender, ageIndex, regDate, status);
	}
	
	@RequestMapping(value="searchMerchants", method={RequestMethod.GET})
	public ModelAndView searchMerchants(String mid, String name, String gender, Integer ageIndex, String regDate, String status) {
        ModelAndView modelAndView = new ModelAndView();
        
        // Set view
        modelAndView.setViewName("searchResult");
        
        // Set match merchant
        List<Merchant> merchants = merchantManager.getMerchantsByCriteria(mid, name, gender, ageIndex, regDate, status);
        modelAndView.addObject("merchants", merchants);
        
		return modelAndView;
	}
	
	@RequestMapping(value="showMerchantDetails", method={RequestMethod.GET})
	public ModelAndView showMerchantDetails(String mid) {
        ModelAndView modelAndView = new ModelAndView();
        
        // Set view
        modelAndView.setViewName("merchantDetails");
        
        // Set match merchant
        Merchant merchant = merchantManager.getMerchantByMid(mid);
        modelAndView.addObject("merchant", merchant);
        
		return modelAndView;
	}
	
	@RequestMapping(value="updateMerchantStatus", method={RequestMethod.POST})
	@ResponseBody
	public Merchant updateMerchantStatus(String mid, String status) {
		Merchant merchant = merchantManager.updateMerchantStatus(mid, status);
		sendUpdateStatus(merchant);
		return merchant;
	}
	
	//http://localhost:8080/Admin/getAdvertisementsByStatus?status=Pending
	@RequestMapping(value="getAdvertisementsByStatus", method={RequestMethod.GET})
	@ResponseBody
	public List<Advertisement> getAdvertisementsByStatus(String status) {
		System.out.println("enter getAdvertisementsByStatus " + status);
		return advertisementManager.getAdvertisementsByStatus(status);
	}
	
	//http://localhost:8080/Admin/updateAdvertisementStatus?advId=-1&status=abc
	@RequestMapping(value="updateAdvertisementStatus", method={RequestMethod.GET})
	@ResponseBody
	public void updateAdvertisementStatus(String advId, String status) {
		System.out.println("enter updateAdvertisementStatus " + status);
		Advertisement adv = advertisementManager.updateAdvertisementStatus(advId, status);
		sendUpdateAdvStatus(adv);
	}
	
	@RequestMapping(value="showAcceptedAdvertisement", method={RequestMethod.GET})
	@ResponseBody
	public List<Advertisement> showAcceptedAdvertisement() {    		
		return advertisementManager.getAdvertisementsByStatus("Accepted");
	}
	
	@RequestMapping(value="controlAdvertisement", method={RequestMethod.GET})
	public void controlAdv(String advId, String status) {  
		advertisementManager.updateAdvertisementStatus(advId, status);
	}
	
	@RequestMapping(value="showRejectedAdvertisement", method={RequestMethod.GET})
	@ResponseBody
	public List<Advertisement> showRejectedAdvertisement() {    		
		return advertisementManager.getAdvertisementsByStatus("Rejected");
	}
	
	private void sendUpdateStatus(Merchant merchant){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConnectionFactory factory = (ActiveMQConnectionFactory)context.getBean("mq");
		
//		Destination queue = new ActiveMQQueue("Test01Q");
		Destination queue = (ActiveMQQueue)context.getBean("statusQueue");
		Connection con = null;
		Session session = null;
		MessageProducer producer = null;
		try {
			con = factory.createConnection();
			con.start();
			session = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			producer = session.createProducer(queue);
			ObjectMapper mapper = new ObjectMapper();
			Merchant m = new Merchant();
			m.setMid(merchant.getMid());
			m.setStatus(merchant.getStatus());
			TextMessage msg = session.createTextMessage(mapper.writeValueAsString(m));
			producer.send(msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e){
			e.printStackTrace();
		}
	}
	
	private void sendUpdateAdvStatus(Advertisement adv){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ConnectionFactory factory = (ActiveMQConnectionFactory)context.getBean("mq");
		
//		Destination queue = new ActiveMQQueue("Test01Q");
		Destination queue = (ActiveMQQueue)context.getBean("advUpdateQueue");
		Connection con = null;
		Session session = null;
		MessageProducer producer = null;
		try {
			con = factory.createConnection();
			con.start();
			session = con.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			producer = session.createProducer(queue);
			ObjectMapper mapper = new ObjectMapper();
			Advertisement a = new Advertisement();
			a.setAdvId(adv.getAdvId());
			a.setStatus(adv.getAdvId());
			TextMessage msg = session.createTextMessage(mapper.writeValueAsString(a));
			producer.send(msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e){
			e.printStackTrace();
		}
	}
}
