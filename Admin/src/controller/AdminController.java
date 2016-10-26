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
        ModelAndView modelAndView = new ModelAndView();
        
        // Set view
        modelAndView.setViewName("index");

        // Set admin object (null if fail)
        Admin admin = adminManager.login(username, password);
        modelAndView.addObject("admin", admin);
        
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
	@ResponseBody
	public List<Merchant> searchMerchants(String mid, String name, String gender, Integer ageIndex, String regDate, String status) {
		return merchantManager.getMerchantsByCriteria(mid, name, gender, ageIndex, regDate, status);
	}
	
	@RequestMapping(value="updateMerchantStatus", method={RequestMethod.POST})
	@ResponseBody
	public Merchant updateMerchantStatus(String mid, String status) {
		Merchant merchant = merchantManager.updateMerchantStatus(mid, status);
		sendUpdateStatus(merchant);
		return merchant;
	}
	
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
		advertisementManager.updateAdvertisementStatus(advId, status);
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
	
}
