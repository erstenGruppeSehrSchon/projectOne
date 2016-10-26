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

import common.util.DateFormatter;
import po.Merchant;
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
	public Merchant getMerchantByMid(int mid) {
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
	public List<Merchant> getMerchantsByCriteria(Integer mid, String name, String gender, Integer ageIndex, String regDate, String status) {
		Session session = (Session)em.getDelegate();
		
		// Add criteria
		Criteria criteria = session.createCriteria(Merchant.class);
		
		if (mid != null) {
			criteria.add(Restrictions.eq("mid", mid));
		}
		
		if (name != null) {
			criteria.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		}
		
		if (gender != null) {
			criteria.add(Restrictions.eq("gender", gender));
		}
		
		if (ageIndex != null) {
			Date currentDate = new Date();
			criteria.add(Restrictions.between(
				"birthDate", 
				getDateBeforeYear(currentDate, AGE_RANGE[ageIndex][1]), 
				getDateBeforeYear(currentDate, AGE_RANGE[ageIndex][0])
			));
		}
		
		if (regDate != null) {
			DateFormatter formatter = DateFormatter.getDateFormatter();
			Date fromDate = formatter.parse(regDate);
			Date toDate = getNextDay(fromDate);
			criteria.add(Restrictions.ge("regDate", fromDate));
			criteria.add(Restrictions.lt("regDate", toDate));
		}
		
		if (status != null) {
			criteria.add(Restrictions.eq("status", status));
		}
		
		List<Merchant> merchants = criteria.list();
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
	public Merchant updateMerchantStatus(int mid, String status) {
		Merchant merchant = em.find(Merchant.class, mid);
		merchant.setStatus(status);
		em.persist(merchant);
		return merchant;
	}
}
