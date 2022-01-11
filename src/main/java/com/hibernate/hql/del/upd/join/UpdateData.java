package com.hibernate.hql.del.upd.join;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateData {
	
	public static void main(String[] args) {
		
    	SessionFactory factory = new Configuration().configure("com/hibernate/hql/del/upd/join/hibernate.cfg.xml").buildSessionFactory();
		
  
    	
    	
    	Session session = factory.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	
    	
    	
    	
    	
    	String  q = "update from College set phone=:p where stuId=:I";
    	
    	Query query = session.createQuery(q);
    	query.setParameter("I", 112);
    	query.setParameter("p", "9744125678");
    	int update = query.executeUpdate();
    	
    	System.out.println("Object updated Successfully");
    	System.out.println("How many row delete do you have :" + update);
    	
    
    	
    	transaction.commit();
    	session.close();
    	factory.close();
	}

}
