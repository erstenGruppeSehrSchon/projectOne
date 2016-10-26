package service;

import java.util.Set;

import po.Address;
import po.Client;

public interface ClientManager {
	
	public boolean register(String username, String password, Set<Address> addresses);
	public Client login(String username,String password);
	
	

}
