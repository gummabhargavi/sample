package com.java.ejb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.security.annotation.ModuleOption.VALUE_TYPE;

public class PaymentDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	public String generatePaymentId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(payment_id) is NULL THEN 'P001' else max(payment_id) end  pid from payment_detail";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		String rid = rs.getString("pid");
		int id = Integer.parseInt(rid.substring(1));
		id++;
		String pid="";
		if (id >=1 && id <=9) {
			pid="P00"+id;
		}
		if (id >=10 && id <= 99) {
			pid="P0"+id;
		}
		if (id >=100 && id<=999) {
			pid="P"+id;
		}
		return pid;
	}
	
	public String addPayment(Payment payment) 
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String s=generatePaymentId();
		String cmd = "insert into payment_detail(payment_id,user_id,wallet_id,booking_id,amount,paymate_date,payment_status,paytype) "
				+ " values(?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
	    pst.setString(1, s);
		pst.setString(2, payment.getUser_id());
		pst.setString(3, payment.getWallet_id());
		pst.setString(4, payment.getBooking_id());
		pst.setFloat(5, payment.getAmount());
		pst.setDate(6, payment.getPaymate_date());
		pst.setString(7, payment.getPayment_status().toString());
		pst.setString(8, payment.getPaytype().toString());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public List<Payment> showPayment() throws 
	ClassNotFoundException, SQLException {
      List<Payment> paymentList = new ArrayList<Payment>();
      connection = ConnectionHelper.getConnection();
      String cmd = "select * from payment_detail";
      pst = connection.prepareStatement(cmd);
      ResultSet rs = pst.executeQuery();
      Payment payment = null;
          while(rs.next()) {
        	  payment = new Payment();
        	  payment.setPayment_id(rs.getString("payment_id"));
        	  payment.setUser_id(rs.getString("user_id"));
        	  payment.setWallet_id(rs.getString("wallet_id"));
        	  payment.setBooking_id(rs.getString("booking_id"));
             payment.setAmount(rs.getFloat("amount"));
             payment.setPaymate_date(rs.getDate("paymate_date"));
           //  payment.setPayment_status(PaymentStatus.valueOf());
             //payment.setPaytype(PayType.valueOf("paytype"));
             paymentList.add(payment);
      }
      return paymentList;
	}
	
	public Payment searcPayment(String payment_id) throws ClassNotFoundException, SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd="select * from payment_detail where payment_id=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, payment_id);
		ResultSet rs = pst.executeQuery();
		Payment payment =null;
		if(rs.next()){
			payment = new Payment();
			payment.setPayment_id(rs.getString("payment_id"));
			payment.setUser_id(rs.getString("user_id"));
			payment.setWallet_id(rs.getString("wallet_id"));
			payment.setBooking_id(rs.getString("booking_id"));
			payment.setAmount(rs.getFloat("amount"));
			payment.setPaymate_date(rs.getDate("paymate_date"));
//			payment.setPayment_status(rs);
//			payment.setPaytype(rs);
			
			
		}
		return payment;
		
		
		
	}
	}
