package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	public List<Bus> showBus() throws 
	ClassNotFoundException, SQLException {
      List<Bus> busList = new ArrayList<Bus>();
      connection = ConnectionHelper.getConnection();
      String cmd = "select * from bus_details";
      pst = connection.prepareStatement(cmd);
      ResultSet rs = pst.executeQuery();
      Bus bus = null;
          while(rs.next()) {
        	  bus = new Bus();
        	  bus.setBus_id(rs.getString("bus_id"));
        	  bus.setBus_no(rs.getString("bus_no"));
        	  bus.setType_of_bus(TypeOfBus.valueOf(rs.getString("type_of_bus")));
        	  bus.setType_of_servies(TypeOfServies.valueOf(rs.getString("type_of_servies")));
        	  bus.setNo_of_seat(rs.getInt("no_of_seat"));
        	  bus.setBus_status(BusStatus.valueOf(rs.getString("bus_status")));
        	  busList.add(bus);
      }
      return busList;
  }
	
	public String generateBusId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(bus_id) is NULL THEN 'B001' else max(bus_id) end  bid from bus_details";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		String rid = rs.getString("bid");
		int id = Integer.parseInt(rid.substring(1));
		id++;
		String bid="";
		if (id >=1 && id <=9) {
			bid="B00"+id;
		}
		if (id >=10 && id <= 99) {
			bid="B0"+id;
		}
		if (id >=100 && id<=999) {
			bid="B"+id;
		}
		return bid;
	}
	public String addBus(Bus bus) 
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String s=generateBusId();
//		bus.setBus_id(s);
		String cmd = "insert into bus_details(bus_id,bus_no,type_of_bus,type_of_servies,no_of_seat,bus_status)"
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, s);
		pst.setString(2, bus.getBus_no());
		pst.setString(3, bus.getType_of_bus().toString());
		pst.setString(4, bus.getType_of_servies().toString());
		pst.setInt(5, bus.getNo_of_seat());
		pst.setString(6, bus.getBus_status().toString());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public Bus searchBus(String bus_id)
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from bus_details where bus_id=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, bus_id);
		ResultSet rs = pst.executeQuery();
		Bus bus = null;
		if(rs.next()) {
			bus = new Bus();
			bus.setBus_id(rs.getString("bus_id"));
			bus.setBus_no(rs.getString("bus_no"));
			bus.setType_of_bus(TypeOfBus.valueOf(rs.getString("type_of_bus")));
			bus.setType_of_servies(TypeOfServies.valueOf(rs.getString("type_of_servies")));
			bus.setNo_of_seat(rs.getInt("no_of_seat"));
			bus.setBus_status(BusStatus.valueOf(rs.getString("bus_status")));
		}
		return bus;
		 
	}
    
	public String updateBus(Bus busNew) 
			throws ClassNotFoundException, SQLException {
		String Id=busNew.getBus_id();
		Bus bus = searchBus(Id);
		if (bus!=null) {
			String cmd ="Update bus_details set bus_no=?, type_of_bus=?, type_of_servies=?, no_of_seat=?, bus_status=? where bus_id=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, busNew.getBus_no());
			pst.setString(2, busNew.getType_of_bus().toString());
			pst.setString(3, busNew.getType_of_servies().toString());
			pst.setInt(4, busNew.getNo_of_seat());
			pst.setString(5, busNew.getBus_status().toString());
			System.out.println(bus.getBus_id());
			pst.setString(6, busNew.getBus_id());
			pst.executeUpdate();
			return "Bus Record Updated...";
		}
		return "Record Not Found...";
	}
	
	public String deleteBus(String bus_id)
			throws ClassNotFoundException, SQLException {
		Bus bus = searchBus(bus_id);
		if (bus!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "delete from bus_details where bus_id=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, bus_id);
			pst.executeUpdate();
			return "Record Deleted...";
		}
		return "Record Not Found...";
	}

 }
