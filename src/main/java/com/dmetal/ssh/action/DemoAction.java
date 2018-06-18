package com.dmetal.ssh.action;
/**
 * Struts 2 d的子控制器
 */
public class DemoAction {
	/**
	 * 控制器中，处理web请求的方法
	 * 默认情况下方法名是execute
	 * 方法的返回值是字符串，值是目标视图的名称
	 */
	public String execute() {
		//调用业务模型/调用业务层
		System.out.println("HelloWorld");
		
		return "success";
	}
	
	 
}
