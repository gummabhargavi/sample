package com.java.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infinite.java.DataBeanStudent;
import com.infinite.java.StudentEntity;

@ManagedBean(name="studentDAOImp1")
@SessionScoped
public class StudentDAOImp1 implements StudentDAO1 {
	 
	SessionFactory sf;
	@Override
	public List<StudentEntity> showStudent() {
		sf=SessionHelper.getConnection();
		Session session =sf.openSession();
		Query query=session.createQuery("from StudentEntity");
		Criteria cr=session.createCriteria(StudentEntity.class);
		List<StudentEntity> ls=query.list();
		return ls;
	}
	
	
	

}
