package com.hibernate.hql.join;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.hql.join.entities.Answer;
import com.hibernate.hql.join.entities.Question;

public class JoinAppToSaveData {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("com/hibernate/hql/join/hibernate.cfg.xml")
				.buildSessionFactory();

		Question q = new Question();
		q.setId(2);
		q.setQuestion("What is oops ");

		Answer a = new Answer();
		a.setId(22);
		a.setAnswer("Oops  is a  part of java programing language");
		a.setQuestion(q);

		Answer a2 = new Answer();
		a2.setId(23);
		a2.setAnswer("Oops is based on multipal functionality");
		a2.setQuestion(q);

		Answer a3 = new Answer();
		a3.setId(24);
		a3.setAnswer("Oops  is main part of java ");
		a3.setQuestion(q);

		List<Answer> list = new ArrayList<Answer>();
		list.add(a);
		list.add(a2);
		list.add(a3);

		q.setAnswers(list);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// Add data in databases;
		session.save(q);
		session.save(a);
		session.save(a2);
		session.save(a3);

		transaction.commit();
		session.close();
		factory.close();
	}

}
