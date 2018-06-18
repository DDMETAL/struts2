package com.dmetal.ssh.action;

public class TestAction {
	private String user;
	private String pwd;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String execute() {
		System.out.println("user:"+user+","+"pwd:"+pwd);
		return "success";
	}
}
