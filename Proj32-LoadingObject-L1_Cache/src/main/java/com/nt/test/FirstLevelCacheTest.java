package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest {

	public static void main(String[] args) {
		Session ses=null;
		InsurancePolicy policy=null,policy1=null;
		//get SEssion object
		ses=HibernateUtil.getSession();
		try {
			//Load object
			policy=ses.load(InsurancePolicy.class,9001L);
			System.out.println(policy);
			policy1=ses.load(InsurancePolicy.class,9001L);
			System.out.println(policy1);
			
		}//try
		catch(HibernateException he) {
			System.out.println("record not found---");
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
