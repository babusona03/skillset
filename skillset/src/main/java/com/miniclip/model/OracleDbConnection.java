package com.miniclip.model;

public class OracleDbConnection extends DbConnection {
	@Override
	public void setConnectionUrl(){
		//this.connectionURL = "jdbc:oracle:"+dbUserInfo.getDriverType()+":"+"@"+dbUserInfo.getHostName()+":"+dbUserInfo.getPortNo()+":"+dbUserInfo.getSid();
		connectionUrl = "jdbc:oracle:"+dcp.getDriverType()+":"+"@"+dcp.getHostName()+":"+dcp.getPort()+":"+dcp.getSid();
		
	}
}
