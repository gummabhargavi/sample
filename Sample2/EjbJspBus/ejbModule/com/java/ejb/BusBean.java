package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BusBean
 */
@Stateless
@Remote(BusBeanRemote.class)
public class BusBean implements BusBeanRemote {
	
static TravelSDAO tdao;
    static{
    	tdao = new TravelSDAO();
    }
	
static BusDAO bdao;
	
	static {
		bdao = new BusDAO();
	}
	
static PaymentDAO edao;
	
	static {
		edao = new PaymentDAO();
	}
	
static UserDAO udao;
	
	static {
		udao = new UserDAO();
	}
	

    /**
     * Default constructor. 
     */
    public BusBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Payment> showPaymentBean() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.showPayment();
	}

	@Override
	public Payment searchPaymentBean(String payment_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.searcPayment(payment_id);
	}

	@Override
	public String addPaymentBean(Payment payment) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.addPayment(payment);
	}
    
	@Override
	public String deletePaymentBean(String payment_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String updatePaymentBean(Payment payment) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> showUserBean() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return udao.showUser();
	}

     //**Bus Details**//	
	@Override
	public List<Bus> showBusBean() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return bdao.showBus();
	}

	@Override
	public String addBusBean(Bus bus) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return bdao.addBus(bus);
	}

	@Override
	public Bus searchBusBean(String bus_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return bdao.searchBus(bus_id);
	}

	@Override
	public String updateBusBean(Bus bus) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return bdao.updateBus(bus);
	}

	@Override
	public String deleteBusBean(String bus_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return bdao.deleteBus(bus_id);
	}

	@Override
	public List<TravelSchedule> showTravelBean() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return tdao.showTravel();
	}

	@Override
	public String addTravelBean(TravelSchedule travel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return tdao.addTravel(travel);
	}

	@Override
	public TravelSchedule searchTravelBean(String schedule_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return tdao.searchTravel(schedule_id);
	}

	@Override
	public String updateTravelBean(TravelSchedule travel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return tdao.updateTravel(travel);
	}

	@Override
	public String deleteTravelBean(String schedule_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return tdao.deleteTravel(schedule_id);
	}

}
