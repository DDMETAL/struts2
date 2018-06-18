package com.dmetal.ssh.action;

public class MessageAction {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String execute() {
		message="OK";
		return "success";
	}
}
