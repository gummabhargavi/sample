package com.infinte.com;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="myBean")
@RequestScoped
public class BeanDemo implements Serializable{
	
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BeanDemo [name=" + name + "]";
	}
	
    public String displayName(){
	   return name;
	     
   }
	
}
