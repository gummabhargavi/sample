package com.java.ejb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateBusServlet
 */
@WebServlet("/UpdateBusServlet")
public class UpdateBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBusServlet() {
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
		
		String bus_id=request.getParameter("bus_id");
		String bus_no=request.getParameter("bus_no");
		String type_of_bus=request.getParameter("type_of_bus");
		String type_of_servies=request.getParameter("type_of_servies");
		int no_of_seat=Integer.parseInt(request.getParameter("no_of_seat"));
		String bus_status=request.getParameter("bus_status");
		//String bus_id=request.getParameter("bus_id");
		//double rating=Double.parseDouble(request.getParameter("rating"));

		Bus bus=new Bus();
		 bus.setBus_id(bus_id);
		 bus.setBus_no(bus_no);
		 bus.setType_of_bus(TypeOfBus.valueOf(type_of_bus));;
		 bus.setType_of_servies(TypeOfServies.valueOf(type_of_servies));
		 bus.setNo_of_seat(no_of_seat);
		 bus.setBus_status(BusStatus.valueOf(bus_status));
		// bus.setBus_id(bus_id);
		 
		
		try {
			service=(BusBeanRemote) new InitialContext().lookup("BusBean/remote");
			out.println(service.updateBusBean(bus));
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
