package com.demo.model;

public class HelloWorldBeans {

	private String name;
	private String emailAddress;
	private String rollNum;


	public HelloWorldBeans(String name, String emailAddress, String rollNum) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.rollNum = rollNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getRollNum() {
		return rollNum;
	}

	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}

	@Override
	public String toString() {
		return "HelloWorldBeans [name=" + name + ", emailAddress=" + emailAddress + ", rollNum=" + rollNum + "]";
	}

	
	
}
