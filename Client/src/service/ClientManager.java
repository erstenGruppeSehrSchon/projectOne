package service;

import java.util.List;

import po.Address;
import po.Client;

public interface ClientManager {
	
//	public Client register(String username, String password, List<Address> addresses);
	public Client login(String username,String password);
	public Client register(String username, String password, List<Address> addresses);
	

}
