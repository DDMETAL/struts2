package com.dmetal.ssh.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RedAction {
	public String execute() {
		System.out.println("red action");
		return "success";
	}
}
