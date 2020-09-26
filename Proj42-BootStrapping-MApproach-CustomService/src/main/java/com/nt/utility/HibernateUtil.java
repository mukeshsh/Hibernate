package com.nt.utility;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.ServiceRegistry;

import com.nt.entity.Product;
import com.nt.service.UserConnectionService;


public class HibernateUtil {

	private static SessionFactory factory;
	
	static {
		Configuration cfg=null;
		try {
			 cfg=new Configuration();
			 StandardServiceRegistryBuilder builder=null;
			 ServiceRegistry  registry=null;
			//set hibernate cfg file explicitely
			 cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			 cfg.addAnnotatedClass(Product.class);
			 //build service Registry
			 builder=new StandardServiceRegistryBuilder();
			 //create service registry
			 builder.addService(ConnectionProvider.class, new UserConnectionService());
			 registry=builder.applySettings(cfg.getProperties()).build();
			//build sessionFactory
			factory=cfg.buildSessionFactory(registry);	
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

