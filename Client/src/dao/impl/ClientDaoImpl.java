package dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Address;
import po.Client;

import common.util.PasswordEncrypter;

import dao.ClientDao;


@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

	@PersistenceContext(name="em")
	private EntityManager em;


	@Override
	public void addClient(String username, String password,Set<Address> addresses) {
		Client newClient = new Client();


		newClient.setUsername(username);
		newClient.setPassword(password);
		newClient.setAddress(addresses);



		em.persist(newClient);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getClientByName(String username) {
		Session session = (Session)em.getDelegate();
		Criteria criteria = session.createCriteria(Client.class);
		criteria.add(Restrictions.eq("username",username));
		List<Client> clientList = criteria.list();
		return clientList;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public Client loginClient(String username, String password) {

		PasswordEncrypter encrypter = PasswordEncrypter.getPasswordEncrypter();

		String encryptedPassword = encrypter.encrypt(password);

		Session session = (Session)em.getDelegate();

		Criteria criteria = session.createCriteria(Client.class);

		criteria.add(Restrictions.eq("username",username));

		criteria.add(Restrictions.eq("password",encryptedPassword));

		Client client = (Client) criteria.uniqueResult();

		if(client!=null){
			return client;
		}else if(client==null){
			System.out.println("Client Login error");
			return null;
		}
		return client;


	}



}
