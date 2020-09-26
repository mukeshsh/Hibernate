package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {

	public static void main(String[] args) {
     
		Session ses=null;
		Product prod=null;
		//get SEssion object
		ses=HibernateUtil.getSession();
		try {
			//Load object
			prod=ses.get(Product.class,32);
			//verify
			if(prod==null)
				System.out.println("Record not found");
			else {
				System.out.println("Record found  and displayed");
				System.out.println(prod);
			}
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
