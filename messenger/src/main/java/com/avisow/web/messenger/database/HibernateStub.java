package com.avisow.web.messenger.database;

import org.hibernate.Session;

import com.avisow.web.messenger.common.Stock;
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

}
