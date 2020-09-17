package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.MobileCustomer;
import com.nt.utility.HibernateUtil;

public class VersionModiyTest {

	public static void main(String[] args) {
		Session ses=null;
		MobileCustomer cust=null;
		Transaction tx=null;
		boolean flag=false;
			
		//get Session
		ses=HibernateUtil.getSession();
		try {
		 tx=ses.beginTransaction();	
	    //Load object 
		cust=ses.get(MobileCustomer.class,6);
		if(cust!=null) {
			 System.out.println(cust);
			// cust.setCallerTune("pyar me sb kuch bekar h");
			 cust.setCname("Karishma");
			 flag=true;
		}
		else
			System.out.println("record not found");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			//perform Tx mgmt
			if(flag) {
				tx.commit();
				System.out.println("object is modified");
				 System.out.println("Object is modified for :: "+cust.getVersionCount()+"times");
			}
			else {
				tx.rollback();
				System.out.println("Object is not modified");
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class

