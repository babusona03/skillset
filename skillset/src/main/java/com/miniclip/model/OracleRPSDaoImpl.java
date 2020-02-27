package com.miniclip.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleRPSDaoImpl implements RPSDao {

	@Override
	public List<RPSData> readRpsData(Connection connection, String query) {
		
		boolean flag = false;
		PreparedStatement ps;
		ResultSet rs;
		RPSData rps;
		List<RPSData> rpsResultSet=null;		
		try{
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			rpsResultSet = new ArrayList<RPSData>();
			flag = (rs==null)?false:true;
			
			if(flag==true){
				while(rs.next()){
					rps = new RPSData();
					rps.setSerial(rs.getInt("SERIAL"));
					rps.setUserChoice(rs.getString("USER_CHOICE"));
					rps.setSystemChoice(rs.getString("SYSTEM_CHOICE"));
					rps.setTimeStamp(rs.getTimestamp("TIME_STAMP"));
					rps.setWinner(rs.getString("WINNER"));
					rpsResultSet.add(rps);
				}
			}
			ps.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
			
			return rpsResultSet;		
	}

	@Override
	public int insertRpsData(Connection connection, String query, RPSData rpsData) {
		int i=0;
		try{
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, rpsData.getUserChoice());
			ps.setString(2, rpsData.getSystemChoice());
			ps.setString(3, rpsData.getWinner());
			i = ps.executeUpdate();
			ps.close();
			System.out.println("No of rows affected : "+i);
		}
		catch(SQLException e){
			e.printStackTrace();
		}		
		return i;		
	}

}
