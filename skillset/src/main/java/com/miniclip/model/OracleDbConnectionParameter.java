package com.miniclip.model;

public class OracleDbConnectionParameter implements DbConnectionParameter {

	private LoginInfo loginInfo;
	private String port;
	private String sid;
	private String driverType;
	private String hostName;
	private String url;
	
	@Override
	public String getUrl() {
		return url;
	}
	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}

	@Override
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}

	
	@Override
	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String getPort() {		
		return port;
	}

	@Override
	public void setSid(String sid) {
		this.sid = sid;
	}

	@Override
	public String getSid() {		
		return sid;
	}

	@Override
	public void setDriverType(String driverType) {
		this.driverType = driverType;
	}

	@Override
	public String getDriverType() {		
		return driverType;
	}

	@Override
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public String getHostName() {	
		return hostName;
	}

}
