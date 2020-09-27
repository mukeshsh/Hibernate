package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest {

	public static void main(String[] args) {
	    
		Session ses=HibernateUtil.getSession();
		 //=================== HQL SELECT SCALAR Query that gives  multiple specifi col values========
		/*	try {
				Transaction tx=ses.beginTransaction(); //dummy
				//prepare Query object
				Query query=ses.createQuery("SELECT pid,pname,price,qty FROM  com.nt.entity.Product WHERE pname like :initLetters  ");
				//set values to query params
				query.setParameter("initLetters","C____");
				//execute HQL query
				List<Object[]> list=query.getResultList();
				//process result
				list.forEach(row->{
					for(Object obj:row) {
						System.out.print(obj+"   ");
					}//for
					System.out.println();
				});
		  }		//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}*/
		
		//  =================== HQL SELECT SCALAR Query that gives  single specific col value========
		/*try {
			Transaction tx=ses.beginTransaction(); //dummy
			//prepare Query object
			Query query=ses.createQuery("SELECT pid FROM  com.nt.entity.Product WHERE price>=:max");
			//set quer param value
			query.setParameter("max", 999.0f);
			//execute Query
			List<Long> list=query.getResultList();
			//process result
			list.forEach(System.out::println);
		}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				HibernateUtil.closeSessionFactory();
			}*/
		
		// =================== HQL SELECT SCALAR Query that gives  single specific col value using iterate()========
		try {
			Transaction tx=ses.beginTransaction(); //dummy
			//prepare Query object
			Query query=ses.createQuery("SELECT pid FROM  com.nt.entity.Product WHERE price>=:max");
			//set quer param value
			query.setParameter("max",9078.0f);
			//execute Query
			Iterator<Long> it=query.iterate();
			//process result
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
			finally {
				HibernateUtil.closeSessionFactory();
			}

					 
	}//main
}//class
