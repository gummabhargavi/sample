package com.java.ejb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowPaymentServlet
 */
@WebServlet("/ShowPaymentServlet")
public class ShowPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusBeanRemote service = null;
		 //PrintWriter out = response.getWriter();
		    try {
				service = 
					(BusBeanRemote) 
					new InitialContext().lookup("BusBean/remote");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
		    List<Payment> payList=null;
		    PrintWriter out = response.getWriter();
		    try {
				payList=service.showPaymentBean();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    for (Payment payment : payList) {
				out.println(payment);
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
