package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;


public class HibernateUtil {

	private static SessionFactory factory;
	
	static {
		Configuration cfg=null;
		try {
			 cfg=new Configuration();
			//set hibernate cfg file explicitely
			 cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
			 cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
			 cfg.setProperty("hibernate.connection.username", "jdbc");
			 cfg.setProperty("hibernate.connection.password", "class");
			 
			 cfg.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.Oracle10gDialect");
			 cfg.setProperty("hibernate.show_sql", "true");
             //specify the name of configure mapping file
			   cfg.addAnnotatedClass(Product.class);
			//build sessionFactory
			factory=cfg.buildSessionFactory();	
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
}

