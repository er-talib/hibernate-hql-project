package com.hibernate.hql.join;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UseJoinQueryApp {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("com/hibernate/hql/join/hibernate.cfg.xml")
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		String q = "select q.id , q.question, a.answer from Question as q inner join q.answers as a";
		Query query = session.createQuery(q);
		List<Object []> list = query.list();
		for(Object [] arr : list) {
			
			System.out.println(Arrays.toString(arr));
		}
			
		session.close();
		factory.close();
	}
}
