package com.dmetal.ssh.action;
/**
 * Struts 2 d���ӿ�����
 */
public class DemoAction {
	/**
	 * �������У�����web����ķ���
	 * Ĭ������·�������execute
	 * �����ķ���ֵ���ַ�����ֵ��Ŀ����ͼ������
	 */
	public String execute() {
		//����ҵ��ģ��/����ҵ���
		System.out.println("HelloWorld");
		
		return "success";
	}
	
	 
}
