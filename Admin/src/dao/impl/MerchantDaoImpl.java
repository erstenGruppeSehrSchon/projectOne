package dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Merchant;

import common.util.DateFormatter;

import dao.MerchantDao;

@Repository
@Transactional
public class MerchantDaoImpl implements MerchantDao {

	private static int[][] AGE_RANGE = new int[][]{
		{0, 20},
		{20, 40},
		{40, 60},
		{60, 80},
		{80, 100}
	};
	
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Merchant getMerchantByMid(String mid) {
		return em.find(Merchant.class, mid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Merchant> getAllMerchants() {
		Session session = (Session)em.getDelegate();
		List<Merchant> merchants = session.createCriteria(Merchant.class).list();
		return merchants;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Merchant> getMerchantsByCriteria(String mid, String name, String gender, Integer ageIndex, String regDate, String status) {
		
		System.out.println("getMerchantsByCriteria");
		
		Session session = (Session)em.getDelegate();
		
		// Add criteria
		Criteria criteria = session.createCriteria(Merchant.class);
		
		if (mid != null && mid.length() > 0) {
			System.out.println("A");
			criteria.add(Restrictions.eq("mid", mid));
		}
		
		if (name != null && name.length() > 0) {
			System.out.println(name);
			criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		}
		
		if (gender != null && !"%".equals(gender)) {
			System.out.println(gender);
			criteria.add(Restrictions.eq("gender", gender));
		}
		
		if (ageIndex != null && ageIndex > 0) {
			System.out.println("D");
			Date currentDate = new Date();
			criteria.add(Restrictions.between(
				"birthDate", 
				getDateBeforeYear(currentDate, AGE_RANGE[ageIndex][1]), 
				getDateBeforeYear(currentDate, AGE_RANGE[ageIndex][0])
			));
		}

		if (regDate != null && regDate.length() > 0) {
			DateFormatter formatter = DateFormatter.getDateFormatter();
			Date fromDate = formatter.parse(regDate.replace("-", "")); // input format is 2016-10-28
			Date toDate = getNextDay(fromDate);
			criteria.add(Restrictions.ge("regDate", fromDate));
			criteria.add(Restrictions.lt("regDate", toDate));
		}
		
		if (status != null && status.length() > 0) {
			criteria.add(Restrictions.eq("status", status));
		}
		
		List<Merchant> merchants = criteria.list();
		System.out.println("merchants: " + merchants);
		return merchants;
	}
	
	private Date getDateBeforeYear(Date currentDate, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.YEAR, -year);
		return calendar.getTime();
	}
	
	public Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}

	@Override
	public Merchant updateMerchantStatus(String mid, String status) {
		Merchant merchant = em.find(Merchant.class, mid);
		merchant.setStatus(status);
		em.persist(merchant);
		return merchant;
	}
	
	@Override
	public Merchant addMerchant(Merchant merchant) {
		em.persist(merchant);
		return merchant;
	}

}
