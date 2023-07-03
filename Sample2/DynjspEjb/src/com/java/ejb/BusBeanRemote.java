package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BusBeanRemote {
	
	List<Payment> showPaymentBean() throws ClassNotFoundException, SQLException;
	Payment searchPaymentBean(String payment_id) throws ClassNotFoundException, SQLException;
	String addPaymentBean(Payment payment) throws ClassNotFoundException, SQLException;;
	String deletePaymentBean(int payment_id) throws ClassNotFoundException, SQLException;;
	String updatePaymentBean(Payment payment) throws ClassNotFoundException, SQLException;;

	List<User> showUserBean() throws ClassNotFoundException, SQLException;

	List<Bus> showBusBean() throws ClassNotFoundException, SQLException;
	String addBusBean(Bus bus) throws ClassNotFoundException, SQLException;;
	Bus searchBusBean(String bus_id) throws ClassNotFoundException, SQLException;
	String updateBusBean(Bus bus) throws ClassNotFoundException, SQLException;;
	String deleteBusBean(String bus_id) throws ClassNotFoundException, SQLException;;

	List<TravelSchedule> showTravelBean() throws ClassNotFoundException, SQLException;
	String addTravelBean(TravelSchedule travel) throws ClassNotFoundException, SQLException;;
	TravelSchedule searchTravelBean(String schedule_id) throws ClassNotFoundException, SQLException;
	String updateTravelBean(TravelSchedule travel) throws ClassNotFoundException, SQLException;;
	String deleteTravelBean(String schedule_id) throws ClassNotFoundException, SQLException;;

}
