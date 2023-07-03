package com.java.infinite;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


@ManagedBean(name="studentDAO")
@RequestScoped
public class StudentDAO {
	
	SessionFactory sf;
	
	public String addStudent(Student stu){
		
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Student.class);
		Transaction trans = session.beginTransaction();
		session.save(stu);
		trans.commit();
		return "ShowStudent";
		
	}
	
	public List<Student> showStudent(){
		sf = SessionHelper.getConnection();
		Session session=sf.openSession();
		org.hibernate.Query query = session.createQuery("from Student");
		Criteria cr = session.createCriteria(Student.class);
		List<Student> busList=query.list();
		return busList;
		
	}
	public static void main(String[] args) {
		SessionFactory sf;
		Student stu1 = new Student( "A", 3, "A", "@gma", "456789");
		sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Student.class);
		Transaction trans = session.beginTransaction();
		session.save(stu1);
		trans.commit();
	}
	
	public String UpdateStudent(Student student){
		sf=SessionHelper.getConnection();
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Student.class);
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(student);
		trans.commit();
		return "ShowStudent";
		
	}

	  public void validatePhnNo(FacesContext context, UIComponent comp,
	            Object value) {

	        System.out.println("inside validate method");
	        String mno = (String) value;
	        boolean flag=false;
	        if (mno.matches("\\d{10}"))  
	        { flag=true;}

	          if(flag==false) {
	              ((UIInput) comp).setValid(false);

	                FacesMessage message = new FacesMessage(
	                        "invalid ContactNumber");
	                context.addMessage(comp.getClientId(context), message); 
	          }
	    }
	  
	      public boolean validateEmail(FacesContext context, UIComponent component, Object value) throws ValidatorException {
	    	    
             String ep="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@(gmail|nic)(\\.com)$";
             Pattern p=Pattern.compile(ep);
	        
	        boolean s= p.matches(ep, value.toString());
	          if(s == false){
	              FacesMessage msg = 
	                  new FacesMessage("E-mail validation failed.", 
	                          "Invalid E-mail acepted only @gov.com or @nic.com");
	              msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	              throw new ValidatorException(msg);
//	              System.out.println(msg.toString());
	          }else{
	        	  System.out.println("Success");
	          }
	          
			return s;
	      }
	  }
	  

