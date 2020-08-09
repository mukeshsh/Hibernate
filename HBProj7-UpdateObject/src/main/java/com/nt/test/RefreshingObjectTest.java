package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class RefreshingObjectTest {

	public static void main(String[] args) {

			Session ses=null;
			Product prod=null;
			
			//get Session
			ses=HibernateUtil.getSession();
			try {
			//Load object for partial modification of the object
		    prod=ses.get(Product.class,1);
		     if(prod!=null) {
				System.out.println(prod);
				System.out.println("modify 1 record in DB table  from SQL prompt/developer");
				try {
				 Thread.sleep(40000);   //modify db table record using SQL prompt or SQL developer
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				ses.refresh(prod);  //Db table row  to Entity object sync
				System.out.println(prod);
		     }
		     else {
		    	 System.out.println("record /object not found");
		     }
			}//try
			catch(HibernateException  he) {
				he.printStackTrace();
			}
			finally {
				//close objs
				 HibernateUtil.closeSession(ses);
				HibernateUtil.closeSessionFactory();
			}//finally
			
			
		}//main

	}//class
