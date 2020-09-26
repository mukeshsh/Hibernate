package com.nt.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;


public class HibernateUtil {

	private static SessionFactory factory;
	
	static {
		Configuration cfg=null;
		InputStream is=null;
		Properties props=null;
		try {
	//	 is=new FileInputStream("src/main/java/hibernate.properties");//default
			is=new FileInputStream("src/main/java/com/nt/commons/anyfile.properties");
			props=new Properties();
			props.load(is);
			cfg=new Configuration();
			cfg.setProperties(props);
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

