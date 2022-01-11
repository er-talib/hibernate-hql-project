package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.pagination.entities.Student;



public class HQLPagination {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("com/pagination/hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = factory.openSession();
		
		String q = "from Student";
		
		Query query = session.createQuery(q);
		query.setFirstResult(2);
		query.setMaxResults(5);
		
		List<Student> list = query.list();
		
		for(Student stu : list) {
			System.out.println(stu.getStuId() + " : " + stu.getStuName() + " : " + stu.getPhone());
		}

		session.close();
		factory.close();
	}
}
