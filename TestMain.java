package com.weiru.view;

import org.hibernate.service.ServiceRegistry;

import com.weiru.hibernate.Employee;

import java.util.Date;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//生成一個註冊對象
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		//用註冊對象serviceRegistry來創建sessionFactory
			SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			Session session = sessionFactory.openSession();
			//開啟事務，舊版org.hibernate.Transcation沒commit()方法能用  
	        EntityTransaction et = session.beginTransaction();
			
			//新增資料
			Employee emp = new Employee();
			emp.setName("rutree");
			emp.setEmail("123@gmail");
			emp.setHiredate(new Date());
			//儲存事務提交
			session.save(emp);
			et.commit();
			session.close();
			
		}
}
