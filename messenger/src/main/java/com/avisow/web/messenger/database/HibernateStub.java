package com.avisow.web.messenger.database;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.avisow.web.messenger.common.Stock;
import com.avisow.web.messenger.model.Profile;
import com.avisow.web.messenger.persistence.HibernateUtil;

public class HibernateStub {
	
	public void insertStock() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 
        session.beginTransaction();
        Stock stock = new Stock();
 
        stock.setStockCode("4715");
        stock.setStockName("GENM");
 
        session.save(stock);
        session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Profile> getProfiles() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Profile> profiles = null;
	      try{
	         profiles = session.createQuery("FROM Profile").list(); 
	      }catch (HibernateException e) {
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      
		return profiles;
	}

	public Profile add(Profile profile) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         session.save(profile);
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      
		return profile;
	}

	public Profile get(long profileId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Profile profile = (Profile) session.load(Profile.class, profileId);
	      
		return profile;
	}

	public Profile update(Profile profile) {
		Profile p = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         
	         p = (Profile) session.load(Profile.class, profile.getId());
	         p.setProfileName(profile.getProfileName());
	         p.setFirstName(profile.getFirstName());
	         p.setLastName(profile.getLastName());
	         
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      
		return p;
		
	}

}
