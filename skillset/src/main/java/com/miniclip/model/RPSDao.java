package com.miniclip.model;

import java.sql.Connection;
import java.util.List;

public interface RPSDao {
	public List<RPSData> readRpsData(Connection connection,String query);
	public int insertRpsData(Connection connection,String query,RPSData rpsData); 	
}
