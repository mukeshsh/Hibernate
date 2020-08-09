package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Membership;
import com.nt.utility.HibernateUtil;

public class MergeObjectTest1 {

	public static void main(String[] args) {
		
		Session ses=null;
		Membership member=null,member1=null,member2=null;
		Transaction tx=null;
		boolean flag=false;
		
		//get session object
		ses=HibernateUtil.getSession();
		//Load Object
		
		member=ses.get(Membership.class, 6L);
		System.out.println(member);
		try {
			//begin transaction
			tx=ses.beginTransaction();
			member1=new Membership();
			member1.setMid(6L);
			member1.setMname("Neha");
			member1.setAddrs("Mariahu");
			member1.setRewardspoints(70L);
			ses.save(member1);
			System.out.println("---------------------------");
		    member2=(Membership) ses.merge(member1);
		    System.out.println(member2);
		    System.out.println(member.hashCode()+"  "+member1.hashCode()+"  "+member2.hashCode());
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
