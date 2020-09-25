package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OracleHibernateUtil {
	private static SessionFactory factory;
	static {
		Configuration cfg=null;
		try {
			//boot straping
			cfg=new Configuration();
			cfg.configure("com/nt/cfgs/oracle-hibernate.cfg.xml");
			
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
		if(ses==null) {
			if(factory!=null) {
				ses=factory.getCurrentSession();
			}
		}
		return ses;
	}
	public static void closeSessionFactory() {
		if(factory!=null) {
			factory.close();
		}
	}
}
