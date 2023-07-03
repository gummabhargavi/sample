package com.java.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.infinite.java.StudentEntity;

@ManagedBean
@SessionScoped
public interface StudentDAO1 {
	
	List<StudentEntity> showStudent();
	

}
