package com.java.infinite;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name="student")
@RequestScoped
@Entity
@Table(name="student_details")
public class Student implements Serializable {
	
	 @Id
	 @Column(name="stu_id")
      public int stuId;
	 
	 @Column(name="stu_name")
      public String stuName;
	 
	 @Column(name="stu_age")
      public int stuAge;
	 
	 public Student( String stuName, int stuAge, String qualification, String email, String phno) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.qualification = qualification;
		this.email = email;
		this.phno = phno;
	}

	@Column(name="stu_qualification")
      public String qualification;
	 
	 @Column(name="stu_email")
      public String email;
	 
	 @Column(name="stu_phno")
      public String phno;
	 
	 @Column(name="rememberMe")
	 public boolean rememberMe;
	 
	public boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public Student() {
		
	}
	   
}
