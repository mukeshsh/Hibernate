package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		int idval=0;
		cfg=new Configuration();
		System.out.println(cfg.getProperties());
		System.out.println("...........................");
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		System.out.println(cfg.getProperties());
		factory=cfg.buildSessionFactory();
		System.out.println("sessionFactory object class name::"+factory.getClass());
		ses=factory.openSession();
		System.out.println("session object class name::"+ses.getClass());
		prod=new Product();
		prod.setPname("chair");

		try {
			tx=ses.beginTransaction();    //internally calls  con.setAutoCommit(false) to begin the Tx
			System.out.println("tx objecct class name::"+tx.getClass());
			//save object
			idval=(int)ses.save(prod);
			System.out.println("Generated id value ::"+idval);
			flag=true;
			System.out.println("id value ::"+prod.getPid());
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag==true) {
				System.out.println("Object is saved/inserted");
			}
			else {
				System.out.println("Object is not saved");
			}

			ses.close();
			factory.close();
		}
	}
}

