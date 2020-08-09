package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class UpDateObjectTest1 {

	public static void main(String[] args) {

		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		boolean flag=false;
		//get session
		ses=HibernateUtil.getSession();
		try {
			//begin Tx
			tx=ses.beginTransaction();
		//Load object for partial moidification of the object
	    prod=ses.get(Product.class, 1);
	     if(prod!=null) {
			
			  //modify object
			 prod.setQty(12);
			  ses.update(prod);
             flag=true;	
	     }
	     else {
	    	 System.out.println("record /object not found");
	    	 return ;
	     }
		}//try
		catch(HibernateException  he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			 if(flag) {
				 tx.commit();
				 System.out.println("Object updated");
			 }
			 else {
				 tx.rollback();
				 System.out.println("object not updated");
			 }
				 
			//close objs
			 HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
		
		
	}//main

}//class
