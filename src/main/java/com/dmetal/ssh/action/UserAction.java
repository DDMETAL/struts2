package com.dmetal.ssh.action;

import com.dmetal.ssh.vo.UserVo;

public class UserAction {
	private UserVo user;	

	public UserVo getUser() {
		return user;
	}

	public void setUser(UserVo user) {
		this.user = user;
	}
	
	public String add() {
		System.out.println(user);
		return "success";
	}
}
