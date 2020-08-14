package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Membership;
import com.nt.utility.HibernateUtil;

public class MergeObjectTest {

	public static void main(String[] args) {
		
		Session ses=null;
		Membership member=null;
		Transaction tx=null;
		boolean flag=false;
		
     
		//get session object
		ses=HibernateUtil.getSession();
		//prepare object
		member=new Membership();
		member.setMid(1L);
		member.setMname("Mukesh");
		member.setAddrs("Siria");
		member.setRewardspoints(77L);
		try {
			//begin transaction
			tx=ses.beginTransaction();
			ses.merge(member);
			flag= true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved or updated");
			}
			else {
				tx.rollback();
				System.out.println("Object is not saved or updated");
			}
			//close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

}
