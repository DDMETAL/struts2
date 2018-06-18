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
//		//创建Session对象
//		Configuration cfg=new Configuration();
//		//读取主配置文件
//		cfg.configure("hibernate.cfg.xml");
//		//创建Session的工厂
//		SessionFactory factory=cfg.buildSessionFactory();
//		//创建Session对象
//		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		User user=new User(1,"DMETAL","123",21,11000.0,new Date(System.currentTimeMillis()));
		session.save(user);
		tx.commit();//提交事务才能执行DML语句
	}
	
	@Test
	public void testGetById() {
		//初始化Hibernate 获取Session对象
		//调用get方法
		//get(类型，对象的主键ID)
		User user=(User)session.get(User.class, 1);
		System.out.println(user);
	}
	
	@Test
	public void testUpdate() {
		Transaction tx=session.beginTransaction();
		User user=(User)session.get(User.class, 1);
		System.out.println(user);
		user.setName("华兰");
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
		//利用Query接口可以执行HQL语句
		Query query=session.createQuery(hql);
		//list  方法执行HQL语句
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
		//替换查询参数
		query.setString(0, name);
		List<Map<String,Object>> list=query.list();
		for(Map<String,Object> map:list) {
			System.out.println(map);
		}
	}
}
