package com.hibernate.hql.del.upd.join;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.hql.del.upd.join.entities.College;

public class DeleteData {

	public static void main(String[] args) {
		
    	SessionFactory factory = new Configuration().configure("com/hibernate/hql/del/upd/join/hibernate.cfg.xml").buildSessionFactory();
		
  
    	
    	
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	
    	
    	
    	
    	
    	String  q = "delete from College where stuId=:I and stuCity=:c";
    	
    	Query query = session.createQuery(q);
    	query.setParameter("I", 121);
    	query.setParameter("c", "Uttar Pradesh");
    	int update = query.executeUpdate();
    	
    	System.out.println("Delete Successfully");
    	System.out.println("How many row delete do you have :" + update);
    	
    
    	
    	transaction.commit();
    	session.close();
    	factory.close();
	}
}
