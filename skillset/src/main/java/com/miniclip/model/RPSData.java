package com.miniclip.model;

import java.sql.Timestamp;

public class RPSData {
	private int serial;
	private String userChoice;
	private String systemChoice;
	private Timestamp timeStamp;
	private String winner;
	
	public RPSData(){
		
	}
	
	public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
	public String getUserChoice() {
		return userChoice;
	}
	public void setUserChoice(String userChoice) {
		this.userChoice = userChoice;
	}
	public String getSystemChoice() {
		return systemChoice;
	}
	public void setSystemChoice(String systemChoice) {
		this.systemChoice = systemChoice;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}	
}
