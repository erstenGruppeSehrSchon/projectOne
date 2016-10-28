package dao;

import java.util.List;
import java.util.Set;

import po.Address;
import po.Client;

public interface ClientDao {

		public Client addClient(String username, String password, List<Address> addresses);
		public List<Client> getClientByName(String username);
		public Client loginClient(String username, String password);
}
