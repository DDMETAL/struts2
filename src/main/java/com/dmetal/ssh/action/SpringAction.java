package com.dmetal.ssh.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller  //spring管理的bean Id:springAction
@Scope("prototype")
public class SpringAction {
	public String execute() {
		//获取调用当前方法的线程
		Thread t=Thread.currentThread();
		System.out.println(t);
		System.out.println("from spring");
		return "success";	
	}
}
