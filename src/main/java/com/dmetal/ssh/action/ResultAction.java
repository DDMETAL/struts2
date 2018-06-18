package com.dmetal.ssh.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ResultAction {
	
	public String execute() {
		System.out.println("result action");
		return "success";
	}
}
