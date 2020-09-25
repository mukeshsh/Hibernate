package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal();
	static{
		Configuration cfg=null;
		try {
			//boot strap hibernate
			cfg=new Configuration();
			cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
			//build SessionFactory
			factory=cfg.buildSessionFactory();
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Session getSession(){
		Session ses=null;
		ses=threadLocal.get();
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