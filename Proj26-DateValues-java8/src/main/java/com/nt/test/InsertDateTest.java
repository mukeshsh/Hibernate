package com.nt.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PersonInfo;
import com.nt.utility.HibernateUtil;

public class InsertDateTest {

	public static void main(String[] args) {
		Session ses=null;
		PersonInfo pinfo=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare entity object
		pinfo=new PersonInfo();
		pinfo.setPname("Mukesh1");
		pinfo.setPaddrs("Jaunpur1");
		pinfo.setEmail("patelmukesh325@gmail.com1");
		pinfo.setDob(LocalDateTime.of(1995, 06, 30, 12, 50, 45));
		pinfo.setDoj(LocalTime.now());
		pinfo.setDom(LocalDate.of(2012, 11, 16));
		try {
			//begin transaction
			tx=ses.beginTransaction();
			ses.save(pinfo);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		finally {
			//perform transaction management
			if(flag) {
				tx.commit();
				System.out.println("object is saved");
			}
			else {
				tx.rollback();
				System.out.println("object is not saved");
			}
			//close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}

}
