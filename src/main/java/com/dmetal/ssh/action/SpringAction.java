package com.dmetal.ssh.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller  //spring�����bean Id:springAction
@Scope("prototype")
public class SpringAction {
	public String execute() {
		//��ȡ���õ�ǰ�������߳�
		Thread t=Thread.currentThread();
		System.out.println(t);
		System.out.println("from spring");
		return "success";	
	}
}
