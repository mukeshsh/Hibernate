package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class DeleteObjectTest1 {

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
    	//load the object
    	std=ses.get(Student.class, 117);
    	if(std!=null) {
    	//delete object
    	ses.delete(std);
    	flag=true;
    	}
    	else {
    		System.out.println("Record not found to delete the object::");
    		flag=false;
    		return;
    	}
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
