package com.miniclip.model;

import java.sql.Connection;

public interface DbServerConnectionBehavior {
	String getConenctiondetails();	
	String getConnectionUrl();
	Connection getConnenction(LoginInfo loginInfo,String conenctionURL);
}
