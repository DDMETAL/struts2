package com.dmetal.ssh.action;

public class JsonResult {
	private static final int SUCCESS=1;
	private static final int ERROR=0;
	
	private int state;
	private String message;
	private Object data;
	
	public JsonResult() {
		
	}
	public JsonResult(Object data) {
		state=SUCCESS;
		this.data=data;
	}
	public JsonResult(Throwable e) {
		state=ERROR;
		this.data=null;
		this.message=e.getMessage();
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
}
