package com.hibernate.hql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.hql.entities.Student;

public class FatchDataApp {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("com/hibernate/hql/hibernate.cfg.xml")
				.buildSessionFactory();

		/// for save data in database ;
//    	
//    	Student stu = new Student();
//    	stu.setPhone("8347573829");
//    	stu.setStuCity("Delhi");
//    	stu.setStuName("Abdul");
//    	stu.setStuId(125);
////    	
//    	Student stu2 = new Student();
//    	stu2.setPhone("8347473393");
//    	stu2.setStuCity("Uttar Pradesh");
//    	stu2.setStuName("Keshav");
//    	stu2.setStuId(129);
////    	
//    	Student stu3 = new Student();
//    	stu3.setPhone("8342229091");
//    	stu3.setStuCity("Hapur");
//    	stu3.setStuName("Aleem");
//    	stu3.setStuId(128);
////    	

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		// use for hql query

		// use for static value
//    	String query = "from Student where stuId=124 and stuCity='Uttar Pradesh'";

		// use for dianamic value
		String query = "from Student where stuId=:x and stuCity=:y ";
//    	String query = "from Student where  stuCity=:y ";

		Query query2 = session.createQuery(query);

		// for dinamic value use
		query2.setParameter("x", 123);
		query2.setParameter("y", "Delhi");

		List<Student> list = query2.list();

		for (Student stu : list) {
			System.out.println(stu.getPhone() + " : " + stu.getStuName() + " : " + stu.getStuId());

		}

// only use to save data in database 
//    	session.save(stu);
//    	session.save(stu2);
//    	session.save(stu3);
//    	

		transaction.commit();

		session.close();
		factory.close();
	}
}
