package com.java.ejb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTravelServlet
 */
@WebServlet("/AddTravelServlet")
public class AddTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTravelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BusBeanRemote service=null;
		PrintWriter out=response.getWriter();
		
		String busid=request.getParameter("bus_id");
		String driverid=request.getParameter("driver_id");
		String startingpoint=request.getParameter("starting_point");
		String destinationpoint=request.getParameter("destination_point");
		
		java.util.Date d = new java.util.Date();
		java.sql.Date d1 = new java.sql.Date(d.getTime());
		Date scheduledate=d1.valueOf((request.getParameter("schedule_date")));
		String departuretime=request.getParameter("departure_time");
		
		java.util.Date d2 = new java.util.Date();
		java.sql.Date d3 = new java.sql.Date(d.getTime());
		Date estimatearrivaldate=d3.valueOf(request.getParameter("estimate_arrival_date"));
		String estimatearrivaltime=request.getParameter("estimate_arrival_time");
		double fareamount=Double.parseDouble(request.getParameter("fare_amount"));
		String remarks=request.getParameter("remark");
		String addressstartingpoint=request.getParameter("address_starting_point");
		String addressdestinationpoint=request.getParameter("address_destination_point");
		//double rating=Double.parseDouble(request.getParameter("rating"));

		TravelSchedule travel=new TravelSchedule();
		travel.setBus_id(busid);
		travel.setDriver_id(driverid);
		travel.setStarting_point(startingpoint);
		travel.setDestination_point(destinationpoint);
		
		travel.setSchedule_date(scheduledate);
		travel.setDeparture_time(departuretime);
		
		travel.setEstimate_arrival_date(estimatearrivaldate);
		travel.setEstimate_arrival_time(estimatearrivaltime);
		travel.setFare_amount(fareamount);
		travel.setRemark(remarks);
		travel.setAddress_starting_point(addressstartingpoint);
		travel.setAddress_destination_point(addressdestinationpoint);
		try {
			service=(BusBeanRemote) new InitialContext().lookup("BusBean/remote");
			out.println(service.addTravelBean(travel));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
