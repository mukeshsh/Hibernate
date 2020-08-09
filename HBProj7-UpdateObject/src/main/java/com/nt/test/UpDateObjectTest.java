package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpDateObjectTest {

	public static void main(String[] args) {

		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		//get session
		ses=HibernateUtil.getSession();
		//prepare full preparation for modification
		prod=new Product();
		prod.setPid(1);
		prod.setPname("Laptop");
		prod.setPrice(34000);
		prod.setQty(5);
		try {
			//begin tx
			tx=ses.beginTransaction();
			ses.update(prod);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object Updated");
			}
			else {
				tx.rollback();
				System.out.println("Object Not Saved");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

}
