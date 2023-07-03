package com.java.ejb;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddPaymentServlet
 */
@WebServlet("/AddPaymentServlet")
public class AddPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Payment payment = new Payment();
		
		payment.setUser_id(request.getParameter("user_id"));
		payment.setWallet_id(request.getParameter("wallet_id"));
		payment.setBooking_id(request.getParameter("booking_id"));
		payment.setAmount((Float.parseFloat(request.getParameter("amount"))));
       
		java.util.Date d = new java.util.Date();
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		
		payment.setPaymate_date(d1.valueOf(request.getParameter("paymate_date")));
        payment.setPayment_status(PaymentStatus.valueOf(request.getParameter("payment_status")));
		payment.setPaytype(PayType.valueOf(request.getParameter("paytype")));
        BusBeanRemote service = null;
		 try {
				service = 
					(BusBeanRemote) 
					new InitialContext().lookup("BusBean/remote");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		PrintWriter out =response.getWriter();
		
			try {
				out.println(service.addPaymentBean(payment));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
