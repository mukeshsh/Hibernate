package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest {

	public static void main(String[] args) {
    Session ses=null;
    Student std=null;
    Transaction tx=null;
    boolean flag=false;
    //get session
    ses=HibernateUtil.getSession();
    try {
    	//begin transaction
    	tx=ses.beginTransaction();
    	std=new Student();
    	std.setRno(119);
    	ses.delete(std);
    	flag=true;
    }
    catch(HibernateException he) {
    	he.printStackTrace();
    	flag=false;
    }
    finally {
    	if(flag) {
    		tx.commit();
    		System.out.println("Record deleted from the table:");
    	}
    	else {
    		tx.rollback();
    		System.out.println("Object not deleted");
    	}
       HibernateUtil.closeSession(ses);
       HibernateUtil.closeSessionFactory();
    }
	}

}
