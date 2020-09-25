package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MysqlHibernateUtil {
	private static SessionFactory factory;
	static {
		Configuration cfg=null;
		try {
			cfg=new Configuration();
			cfg.configure("com/nt/cfgs/mysql-hibernate.cfg.xml");
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
		if(factory!=null)
			factory.close();
	}
}
