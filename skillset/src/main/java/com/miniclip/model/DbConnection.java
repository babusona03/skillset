package com.miniclip.model;

import java.sql.Connection;

public abstract class DbConnection {
	protected DbServerConnectionBehavior dscb;
	protected DbConnectionParameter dcp;
	protected String connectionUrl;
	protected Connection connection;
	
	public DbServerConnectionBehavior getDscb() {
		return dscb;
	}
	public void setDscb(DbServerConnectionBehavior dscb) {
		this.dscb = dscb;
	}
	public DbConnectionParameter getDcp() {
		return dcp;
	}
	public void setDcp(DbConnectionParameter dcp) {
		this.dcp = dcp;
	}
	public String getConnectionUrl() {
		return connectionUrl;
	}
	public abstract void setConnectionUrl(); 
	
	
	public Connection getConnection() {		
		return connection;
	}
	
	public void setConnection() {
		try{
			dscb = new OracleDbServerConnectionbehavior();
		if(connection !=null){
			closeConnection(false);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			this.connection= dscb.getConnenction(this.getDcp().getLoginInfo(), connectionUrl);
		}
		//
	}
	
	public boolean closeConnection(boolean keepAlive) {
		try{
		if(connection!=null){
			if(connection.isClosed()!=true){
				connection.close();
			}
			if(keepAlive ==false){
				connection = null;
			}
		}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
