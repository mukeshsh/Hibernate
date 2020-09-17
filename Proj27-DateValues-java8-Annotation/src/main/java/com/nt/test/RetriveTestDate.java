package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.PersonInfo;
import com.nt.utility.HibernateUtil;

public class RetriveTestDate {

	public static void main(String[] args) {
		
		Session ses=null;
		PersonInfo info=null;
		//get session
       ses=HibernateUtil.getSession();
       try {
    	   info=ses.get(PersonInfo.class, 43);
    	   if(info!=null) {
    		   System.out.println(info);
    	   }
    	   else {
    		   System.out.println("Record not found");
    	   }
       }
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
