package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class LoadTest {
	public static void main(String[] args) {
      Session ses=null;
      InsurancePolicy policy=null;
		//get Session Object
      ses=HibernateUtil.getSession();
      try {
    	  //load object
    	  policy=ses.get(InsurancePolicy.class, 9001L);
    	  if(policy==null) {
    		  System.out.println("Record are not found::");
    	  }
    		  else {
    			  System.out.println("Records Found and displayed::"+policy);
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
