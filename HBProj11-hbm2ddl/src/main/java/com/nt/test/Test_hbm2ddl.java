package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class Test_hbm2ddl {

	public static void main(String[] args) {

		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		//get session object
		ses=HibernateUtil.getSession();
		//prepare object
		emp=new Employee();
		emp.setEid(3);
		emp.setEname("Jaya");
		emp.setEaddrs("Varanasi");
		emp.setEsalary(76.34f);
		emp.setAge(25);
		try {
			tx=ses.beginTransaction();
			ses.save(emp);
			flag=true;
		}
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Table created");
			}
			else {
				tx.rollback();
				System.out.println("Table is not created");
			}
			//close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
	}


}
