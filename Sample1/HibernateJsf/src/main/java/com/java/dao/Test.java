package com.java.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infinite.java.StudentEntity;

public class Test {
	
	public static void main(String[] args) {
		SessionFactory sf;
		StudentDAOImp1 dao=new StudentDAOImp1();
		sf=SessionHelper.getConnection();
		Session session =sf.openSession();
		Query query=session.createQuery("from StudentEntity");
		Criteria cr=session.createCriteria(StudentEntity.class);
		List<StudentEntity> ls=query.list();
		//System.out.println(ls);
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls);
		}
	}

}
