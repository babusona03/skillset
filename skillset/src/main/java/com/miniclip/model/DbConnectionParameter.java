package com.miniclip.model;

public interface DbConnectionParameter {
	public void setLoginInfo(LoginInfo loginInfo);
	public LoginInfo getLoginInfo();
	
	public void setPort(String port);
	public String getPort();
	
	public void setSid(String Sid);
	public String getSid();
	
	public void setDriverType(String driverType);
	public String getDriverType();
	
	public void setHostName(String hostName);
	public String getHostName();
	
	public void setUrl(String url);
	public String getUrl();
	
	
}
