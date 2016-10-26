package dao;

import java.util.List;
import java.util.Set;

import po.Address;
import po.Client;

public interface ClientDao {

		public void addClient(String username, String password, Set<Address> addresses);
		public List<Client> getClientByName(String username);
		public Client loginClient(String username, String password);
}
