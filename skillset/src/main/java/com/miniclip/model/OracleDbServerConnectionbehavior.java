package com.miniclip.model;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleDbServerConnectionbehavior implements DbServerConnectionBehavior {

	@Override
	public String getConenctiondetails() {		
		return null;
	}

	@Override
	public String getConnectionUrl() {		
		return null;
	}

	@Override
	public Connection getConnenction(LoginInfo loginInfo, String connectionUrl) {
		 Connection connection= null;
		 OracleDataSource ods = null;
		 try{
			 ods = new OracleDataSource();
			 ods.setURL(connectionUrl);
			 connection= ods.getConnection(loginInfo.getUserName(), loginInfo.getPassword());
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }		 
		 return connection;		 
	}
}
