package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;

public class AnnoTest {

	public static void main(String[] args) {
     
		Session ses=null;
		Project proj=null;
		Transaction tx=null;
		boolean flag=false;
		Long idVal=0L;
		//load the session
		ses=HibernateUtil.getSession();
		//create entity class object
		proj=new Project();
		proj.setProjId(1013L);
		proj.setProjName("Yes");
		proj.setTeamSize(133);
		proj.setCompany("Birla");
		proj.setAmount(80000f);
		try {
           tx=ses.beginTransaction();
          idVal= (Long) ses.save(proj);
          System.out.println("generated Id Value::"+idVal);
           flag=true;
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				tx.commit();
			System.out.println("Object saved");
			}
			else {
				tx.rollback();
			System.out.println("object is not saved");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}
}
