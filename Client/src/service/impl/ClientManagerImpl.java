package service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.Address;
import po.Client;
import service.ClientManager;

import common.util.PasswordEncrypter;

import dao.ClientDao;


//@Component
@Service
public class ClientManagerImpl implements ClientManager{

	@Autowired
	private ClientDao clientDao;

	@Override
	public Client login(String username, String password) {

		Client client = clientDao.loginClient(username, password);

		if(client != null){
			client.setPassword(null);
			return client;
		}else{
			System.out.println("Can't Login with this set username and password set");
			return null;
		}



	}

	@Override
	public boolean register(String username, String password, Set<Address> addresses) {
		
		if(!username.isEmpty()&&!password.isEmpty()&&!addresses.isEmpty()){

			List<Client> clientList = clientDao.getClientByName(username);

			if(clientList.size()>0){
				System.out.println("Client Name registered");
				return false;
			}else{
				PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();
				String encryptedPassword = encrypter.encrypt(password);
				System.out.println("encryptedPassword" + encryptedPassword + username + addresses);
				clientDao.addClient(username, encryptedPassword, addresses);
				return true;
			}

		}else{
			System.out.println("You empty something");
			return false;
		}


	}
}


