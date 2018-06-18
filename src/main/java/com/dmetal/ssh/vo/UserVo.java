package com.dmetal.ssh.vo;

import java.io.Serializable;

public class UserVo implements Serializable{
	private static final long serialVersionUID = 4278213558121086379L;
	
	private String name;
	private String sex;
	private Double salary;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "UserVo [name=" + name + ", sex=" + sex + ", salary=" + salary + "]";
	}
	
}
