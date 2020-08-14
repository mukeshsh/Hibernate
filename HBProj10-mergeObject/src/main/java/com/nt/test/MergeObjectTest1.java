package com.nt.test;

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
	     //get Session
		ses=HibernateUtil.getSession();
		//Load object
		member=ses.get(Membership.class,2L);
		System.out.println(member);
		try {
			tx=ses.beginTransaction();
			member1=new Membership();
		    member1.setMid(2L);
		    member1.setMname("Mukesh");
			member1.setAddrs("Kolkata");
			member1.setRewardspoints(37L);
			//ses.update(member1);  //throws  NonUniqueObjectException
			//ses.save(member1);  //throws NonUniqueObjectException
			//ses.delete(member1);//throws  EntityExistsException
			//ses.saveOrUpdate(member1);	 //throws throws NonUniqueObjectException
			member2=(Membership) ses.merge(member1);
			System.out.println(member2);
			System.out.println(member.hashCode()+"  "+member1.hashCode()+"  "+member2.hashCode());
			flag=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Object updated");
			}
			else {
				tx.rollback();
				System.out.println("Object not updated");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
		}//main
}//class
