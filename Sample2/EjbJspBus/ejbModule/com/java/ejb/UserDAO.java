package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	public List<User> showUser() throws 
	ClassNotFoundException, SQLException {
      List<User> userList = new ArrayList<User>();
      connection = ConnectionHelper.getConnection();
      String cmd = "select * from user_detail";
      pst = connection.prepareStatement(cmd);
      ResultSet rs = pst.executeQuery();
      User user = null;
          while(rs.next()) {
        	  user = new User();
        	  user.setUser_id(rs.getString("user_id"));
        	  user.setFull_name(rs.getString("full_name"));
        	  user.setContact_no(rs.getString("contact_no"));
        	  user.setEmail(rs.getString("email"));
        	  user.setUsername(rs.getString("username"));
        	  user.setPsswd(rs.getString("psswd"));
        	  userList.add(user);
      }
      return userList;
  }

}
