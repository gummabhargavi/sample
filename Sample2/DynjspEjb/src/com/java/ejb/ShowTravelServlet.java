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
 * Servlet implementation class ShowTravelServlet
 */
@WebServlet("/ShowTravelServlet")
public class ShowTravelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTravelServlet() {
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
		
		try {
			service=(BusBeanRemote) new InitialContext().lookup("BusBean/remote");
			List<TravelSchedule> travelList=service.showTravelBean();
			out.println("<table border=1");
			 out.println("<tr><th>ScheduleId</th>"
			 		+ "<th>BusId</th>"
			 		+ "<th>DriverId</th>"
			 		+ "<th>StartingPoint</th>"
			 		+ "<th>DestinationPoint</th>"
			 		+ "<th>ScheduleDate</th>"
			 		+ "<th>DepartureTime</th>"
			 		+ "<th>EstimateArrivalDate</th>"
			 		+ "<th>EstimateArrivalTime</th>"
			 		+ "<th>FareAmount</th>"
			 		+ "<th>Remarks</th>"
			 		+ "<th>AddressStartingPoint</th>"
			 		+ "<th>AddressDestinationPoint</th>"
			 		+ "</tr>");
			for (TravelSchedule travel : travelList) {
				
		
	out.println("<tr><td>"+travel.getSchedule_id()
        + "</td><td>"+travel.getBus_id()+"</td>"
        		+ "<td>"+travel.getDriver_id()+"</td>"
        		+ "<td>"+travel.getStarting_point()+"</td>"
		        +"<td>"+travel.getDestination_point()+"</td>"
				+ "<td>"+travel.getSchedule_date()+"</td>"
	      		+ "<td>"+travel.getDeparture_time()+"</td>"
	      		+ "<td>"+travel.getEstimate_arrival_date()+"</td>"
	  			+ "<td>"+travel.getEstimate_arrival_time()+"</td>"
	     		+ "<td>"+travel.getFare_amount()+"</td>"
	     		+ "<td>"+travel.getRemark()+"</td>" 
	     		+ "<td>"+travel.getAddress_starting_point()+"</td>"
	     		+ "<td>"+travel.getAddress_destination_point()+"</td></tr>");
				
			}out.println("</table>"); 
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
