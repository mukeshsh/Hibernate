package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.nt.entity.ProgrammerProjId;
import com.nt.entity.ProgrammerProjInfo;
import com.nt.utility.HibernateUtil;

public class LoadObjeTest {

	public static void main(String[] args) {
		Session ses=null;
		ProgrammerProjInfo info=null;
		ProgrammerProjId id=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
			id=new ProgrammerProjId();
			id.setPid(1002);id.setProjId(5001);
			//load the object
			info=ses.get(ProgrammerProjInfo.class, id);
			if(info!=null)
				System.out.println(info);
			else
				System.out.println("object not found");
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}

}
