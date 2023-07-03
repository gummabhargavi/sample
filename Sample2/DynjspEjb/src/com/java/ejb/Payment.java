package com.java.ejb;

import java.io.Serializable;
import java.sql.Date;


public class Payment implements Serializable {

	private String payment_id;
	private String user_id;
	private String wallet_id;
	private String booking_id;
	private float amount;
	private Date paymate_date;
	private PaymentStatus payment_status;
	private PayType paytype;
	
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getWallet_id() {
		return wallet_id;
	}
	public void setWallet_id(String wallet_id) {
		this.wallet_id = wallet_id;
	}
	public String getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getPaymate_date() {
		return paymate_date;
	}
	public void setPaymate_date(Date paymate_date) {
		this.paymate_date = paymate_date;
	}
	public PaymentStatus getPayment_status() {
		return payment_status;
	}
	public void setPayment_status(PaymentStatus payment_status) {
		this.payment_status = payment_status;
	}
	public PayType getPaytype() {
		return paytype;
	}
	public void setPaytype(PayType paytype) {
		this.paytype = paytype;
	}
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", user_id=" + user_id + ", wallet_id=" + wallet_id
				+ ", booking_id=" + booking_id + ", amount=" + amount + ", paymate_date=" + paymate_date
				+ ", payment_status=" + payment_status + ", paytype=" + paytype + "]";
	}
	public Payment(String payment_id, String user_id, String wallet_id, String booking_id, float amount,
			Date paymate_date, PaymentStatus payment_status, PayType paytype) {
		
		this.payment_id = payment_id;
		this.user_id = user_id;
		this.wallet_id = wallet_id;
		this.booking_id = booking_id;
		this.amount = amount;
		this.paymate_date = paymate_date;
		this.payment_status = payment_status;
		this.paytype = paytype;
	}
	public Payment() {
		
		// TODO Auto-generated constructor stub
	}
	
	
}
