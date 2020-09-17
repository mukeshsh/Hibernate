package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.MobileCustomer;
import com.nt.utility.HibernateUtil;

public class VersionInsertionTest {

	public static void main(String[] args) {
       Session ses=null;
       MobileCustomer cust=null;
       Transaction tx=null;
       Integer idVal=null;
       boolean flag=false;
		//get session
       ses=HibernateUtil.getSession();
       //entity object
       cust=new MobileCustomer();
       cust.setCname("Alia Bhatt");
       cust.setCaddrs("Mumbai");
       cust.setMobileNo(7007891408L);
       cust.setCallerTune("Yadd teri ati h");
       try {
    	   //beging tx
    	   tx=ses.beginTransaction();
    	   idVal=(Integer) ses.save(cust);
    	   System.out.println("  "+idVal);
    	   flag=true;
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
    	   if(flag) {
    		   tx.commit();
    		   System.out.println("Object is saved");
    	   }
    	   else {
    		   tx.rollback();
    		   System.out.println("obejct is not saved");
    	   }
    	   //close
    	   HibernateUtil.closeSession(ses);
    	   HibernateUtil.closeSessionFactory();
       }
	}
}
