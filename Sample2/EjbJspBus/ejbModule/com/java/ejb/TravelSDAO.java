package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TravelSDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	public List<TravelSchedule> showTravel() throws 
	ClassNotFoundException, SQLException {
      List<TravelSchedule> travelList = new ArrayList<TravelSchedule>();
      connection = ConnectionHelper.getConnection();
      String cmd = "select * from travel_schedule";
      pst = connection.prepareStatement(cmd);
      ResultSet rs = pst.executeQuery();
      TravelSchedule travel = null;
          while(rs.next()) {
        	  travel = new TravelSchedule();
        	  travel.setSchedule_id(rs.getString("schedule_id"));
        	  travel.setBus_id(rs.getString("bus_id"));
        	  travel.setDriver_id(rs.getString("driver_id"));
        	  travel.setStarting_point(rs.getString("starting_point"));
        	  travel.setDestination_point(rs.getString("destination_point"));
        	  travel.setSchedule_date(rs.getDate("schedule_date"));
        	  travel.setDeparture_time(rs.getString("departure_time"));
        	  travel.setEstimate_arrival_date(rs.getDate("estimate_arrival_date"));
        	  travel.setEstimate_arrival_time(rs.getString("estimate_arrival_time"));
        	  travel.setFare_amount(rs.getDouble("fare_amount"));
        	  travel.setRemark(rs.getString("remark"));
        	  travel.setAddress_starting_point(rs.getString("address_starting_point"));
        	  travel.setAddress_destination_point(rs.getString("address_destination_point"));
        	  
        	  travelList.add(travel);
      }
      return travelList;
  }
	
	public String generateTravelId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(schedule_id) is NULL THEN 'S001' else max(schedule_id) end  sid from travel_schedule";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		String rid = rs.getString("sid");
		int id = Integer.parseInt(rid.substring(1));
		id++;
		String sid="";
		if (id >=1 && id <=9) {
			sid="S00"+id;
		}
		if (id >=10 && id <= 99) {
			sid="S0"+id;
		}
		if (id >=100 && id<=999) {
			sid="S"+id;
		}
		return sid;
	}
	
	public String addTravel(TravelSchedule travel) 
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String s=generateTravelId();
//		bus.setBus_id(s);
		String cmd = "insert into travel_schedule(schedule_id,bus_id,driver_id,starting_point,"
				+ "destination_point,schedule_date,departure_time,estimate_arrival_date,"
				+ "estimate_arrival_time,fare_amount,remark,address_starting_point,address_destination_point)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, s);
		pst.setString(2, travel.getBus_id());
		pst.setString(3, travel.getDriver_id());
		pst.setString(4, travel.getStarting_point());
		pst.setString(5, travel.getDestination_point());
		pst.setDate(6, travel.getSchedule_date());
		pst.setString(7, travel.getDeparture_time());
		pst.setDate(8, travel.getEstimate_arrival_date());
		pst.setString(9, travel.getEstimate_arrival_time());
		pst.setDouble(10, travel.getFare_amount());
		pst.setString(11, travel.getRemark());
		pst.setString(12, travel.getAddress_starting_point());
		pst.setString(13, travel.getAddress_destination_point());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public TravelSchedule searchTravel(String schedule_id)
			throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from travel_schedule where schedule_id=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, schedule_id);
		ResultSet rs = pst.executeQuery();
		TravelSchedule travel = null;
		if(rs.next()) {
			travel = new TravelSchedule();
			travel.setSchedule_id(rs.getString("schedule_id"));
			travel.setBus_id(rs.getString("bus_id"));
			travel.setDriver_id(rs.getString("driver_id"));
			travel.setStarting_point(rs.getString("starting_point"));
			travel.setDestination_point(rs.getString("destination_point"));
			travel.setSchedule_date((rs.getDate("schedule_date")));
			travel.setDeparture_time((rs.getString("departure_time")));
			travel.setEstimate_arrival_date(rs.getDate("estimate_arrival_date"));
			travel.setEstimate_arrival_time(rs.getString("estimate_arrival_time"));
			travel.setFare_amount(rs.getDouble("fare_amount"));
			travel.setRemark(rs.getString("remark"));
			travel.setAddress_starting_point(rs.getString("address_starting_point"));
			travel.setAddress_destination_point(rs.getString("address_destination_point"));
		}
		return travel;
		 
	}
	
	public String updateTravel(TravelSchedule travelNew) 
			throws ClassNotFoundException, SQLException {
		String Id=travelNew.getSchedule_id();
		TravelSchedule travel = searchTravel(Id);
		if (travel!=null) {
			String cmd ="Update travel_schedule set bus_id=?,driver_id=?,starting_point=?, "
					+ "destination_point=?,schedule_date=?,departure_time=?,"
					+ "estimate_arrival_date=?,estimate_arrival_time=?,fare_amount=?,"
					+ "remark=?,address_starting_point=?,address_destination_point=? where schedule_id=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, travelNew.getBus_id());
			pst.setString(2, travelNew.getDriver_id());
			pst.setString(3, travelNew.getStarting_point());
			pst.setString(4, travelNew.getDestination_point());
			pst.setDate(5, travelNew.getSchedule_date());
			pst.setString(6, travelNew.getDeparture_time());
			pst.setDate(7, travelNew.getEstimate_arrival_date());
			pst.setString(8, travelNew.getEstimate_arrival_time());
			pst.setDouble(9, travelNew.getFare_amount());
			pst.setString(10, travelNew.getRemark());
			pst.setString(11, travelNew.getAddress_starting_point());
			pst.setString(12, travelNew.getAddress_destination_point());
			System.out.println(travel.getSchedule_id());
			pst.setString(13, travelNew.getSchedule_id());
			pst.executeUpdate();
			return "Record Updated...";
		}
		return "Record Not Found...";
	}
	
	public String deleteTravel(String schedule_id)
			throws ClassNotFoundException, SQLException {
		TravelSchedule travel = searchTravel(schedule_id);
		if (travel!=null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "delete from travel_schedule where schedule_id=?";
			pst = connection.prepareStatement(cmd);
			pst.setString(1, schedule_id);
			pst.executeUpdate();
			return "Record Deleted...";
		}
		return " Record Not Found...";
	}

}
