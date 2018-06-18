package com.dmetal.ssh.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RootAction {
	private String name;
	private JsonResult jsonResult;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public JsonResult getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(JsonResult jsonResult) {
		this.jsonResult = jsonResult;
	}
	
	public String execute() {
		name="»ªÀ¼";
		jsonResult=new JsonResult("Hello");
		return "success";
	}
}

