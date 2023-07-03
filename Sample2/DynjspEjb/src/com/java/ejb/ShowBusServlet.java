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
 * Servlet implementation class ShowBusServlet
 */
@WebServlet("/ShowBusServlet")
public class ShowBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBusServlet() {
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
			List<Bus> busList=service.showBusBean();
			out.println("<table border=1");
			 out.println("<tr><th>BusId</th>"
			 		+ "<th>BusNo</th>"
			 		+ "<th>BusType</th>"
			 		+ "<th>BusServies</th>"
			 		+ "<th>NoOfSeats</th>"
			 		+ "<th>BusStatus</th>"
			 		+ "<th>Update</th></tr>");
			for (Bus bus : busList) {
				
		
	out.println("<tr><td>"+bus.getBus_id()
        + "</td><td>"+bus.getBus_no()+"</td>"
        		+ "<td>"+bus.getType_of_bus()+"</td>"
        				+ "<td>"+bus.getType_of_servies()
		+"</td><td>"+bus.getNo_of_seat()+"</td>"
				+ "<td>"+bus.getBus_status()+"</td></tr>");
				
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
