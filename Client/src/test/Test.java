package test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Address;
import po.Client;
import po.Shop;
import service.ClientManager;
import service.OrderManager;
import service.ShopManager;

public class Test {

	@org.junit.Test
	public void TestClientRegisterandLogin() {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClientManager cm = (ClientManager)context.getBean(ClientManager.class);
		
		
		String username = "TestClientName";
		String password = "TestClientPassword";
		Client client = new Client();
		
		Set<Address> address = new HashSet<Address>();
		
		Address addr1 = new Address();
		Address addr2 = new Address();
		
		addr1.setBlock("H");
		addr1.setCity("hK");
		addr1.setBuliding("Bulidingone");
		addr1.setFloor("10");
		addr1.setRoom("01");
		addr1.setZipcode("10");
		
		
		addr2.setBlock("H2");
		addr2.setCity("hK2");
		addr2.setBuliding("Bulidingone2");
		addr2.setFloor("10");
		addr2.setRoom("01");
		addr2.setZipcode("10");
		
		address.add(addr1);
		address.add(addr2);
		
		boolean t = cm.register(username, password, address);
		client = cm.login(username, password);
		System.out.println("username:" + client.getUsername());
		System.out.println("password:" + client.getPassword()); //should be null
		
		Set<Address> resultaddress = client.getAddress();
		for(Address addr:resultaddress){
		System.out.println("address:" + addr.getCity());
		}
		
		
		
	

	}
	
	@org.junit.Test
	public void TestOrderAdd() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderManager om = (OrderManager)context.getBean(OrderManager.class);
		ShopManager sm = (ShopManager)context.getBean(ShopManager.class);
		
	    List<Shop> shops = sm.getAllShops();
	    for(Shop shop:shops){
	    	System.out.println(shop.getName());
	    }
		
		
	}

}
