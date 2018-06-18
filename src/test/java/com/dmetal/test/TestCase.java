package com.dmetal.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dmetal.ssh.entity.User;



public class TestCase {
	Configuration cfg;
	SessionFactory factory;
	Session session;
	
	@Before
	public void init() {
		cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		session=factory.openSession();
	}
	@After
	public void close() {
		session.close();
		factory.close();
	}
	@Test
	public void testSaveUser() {
//		//����Session����
//		Configuration cfg=new Configuration();
//		//��ȡ�������ļ�
//		cfg.configure("hibernate.cfg.xml");
//		//����Session�Ĺ���
//		SessionFactory factory=cfg.buildSessionFactory();
//		//����Session����
//		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		User user=new User(1,"DMETAL","123",21,11000.0,new Date(System.currentTimeMillis()));
		session.save(user);
		tx.commit();//�ύ�������ִ��DML���
	}
	
	@Test
	public void testGetById() {
		//��ʼ��Hibernate ��ȡSession����
		//����get����
		//get(���ͣ����������ID)
		User user=(User)session.get(User.class, 1);
		System.out.println(user);
	}
	
	@Test
	public void testUpdate() {
		Transaction tx=session.beginTransaction();
		User user=(User)session.get(User.class, 1);
		System.out.println(user);
		user.setName("����");
		session.update(user);
		user=(User)session.get(User.class, 1);
		System.out.println(user);
		tx.commit();
	}
	
	@Test
	public void testDelete() {
		Transaction tx=session.beginTransaction();
		User user=(User)session.get(User.class, 1);
		session.delete(user);
		tx.commit();
	}
	
	@Test
	public void testFindAll() {
		//SQL:select * from t_user
		//HQL:from User
		String hql="from User";
		//����Query�ӿڿ���ִ��HQL���
		Query query=session.createQuery(hql);
		//list  ����ִ��HQL���
		List<User> list=query.list();
		for(User user:list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testFindByMap() {
		//SQL:select u_id,u_name from t_user
		//HQL:select new map(id as id,name as name) from User
		String hql="select new map(id as id,name as name) from User ";
		Query query=session.createQuery(hql);
		List<Map<String,Object>> list=query.list();
		for(Map<String,Object> map:list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testFindByParam() {
		//SQL:select u_id,u_name,u_password from t_user where u_name=?
		//HQL:select new map(id as id,name as name,password as password) from User where name=?
		String name="DMETAL";
		String hql="select new map(id as id,name as name,password as password) "
				+ "from User "
				+ "where name=? ";
		Query query=session.createQuery(hql);
		//�滻��ѯ����
		query.setString(0, name);
		List<Map<String,Object>> list=query.list();
		for(Map<String,Object> map:list) {
			System.out.println(map);
		}
	}
}
