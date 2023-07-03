package com.infinite.java;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean
@SessionScoped
/*
@Entity
@Table(name="student_details")*/
public class DataBeanStudent {
	
    public int stuId;
    public String stuName;
    public int stuAge;
    public String qualification;
    public String email;
    public String phno;
	
	
//	/*@Id*/
//	@Column(name="stu_id")
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	
	//@Column(name="stu_name")
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	//@Column(name="stu_age")
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	
	//@Column(name="stu_qualification")
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	//@Column(name="stu_email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//@Column(name="stu_phno")
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}

    
}
