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
		/*try {
			Transaction tx=ses.beginTransaction(); //dummy
			//prepare Query object
			//Query query=ses.createQuery("FROM  com.nt.entity.Product");
			Query<Product> query=ses.createQuery("SELECT p FROM com.nt.entity.Product p");
			//execute query
	     	List<Product>	list=query.getResultList();
			//process the result
			//list.forEach(policy->{     //java 8 for Each method with Lamda expression
				//System.out.println(prod);
			//});
			list.forEach(System.out::println);   // java 8 forEach method + Method reference
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}
     */
		
		//------------------------Executing HQL Query Entity through iterator()----------------------------------------------------
		/*try {
			Transaction tx=ses.beginTransaction(); //dummy
			//prepare Query object
			Query<Product> query=ses.createQuery("FROM  com.nt.entity.Product");
			//execute HQL query
			Iterator<Product> it=query.iterate();  //retuns ListBO refered by Iterator object
			//process Result
			while(it.hasNext()) {
				Product prod=it.next();
				System.out.println(prod);
			}
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSessionFactory();
		}*/
		
		//-----------------------------------HQL SElect Entity query with JPA style positional------------------
		
		/*try {
			Transaction tx=ses.beginTransaction(); //dummy
			//prepare Query object
			Query<Product> query=ses.createQuery("FROM com.nt.entity.Product WHERE pid>=?1 AND pid<=?2");
			//set query param values
			query.setInteger(1,3);
			query.setInteger(2, 9);  //deprecated from 5.2 
			//query.setParameter(2,9);
			//query.setParameter(3, 13);
			//execute the query
			List<Product> list=query.getResultList();
			//process the collection
			list.forEach(System.out::println);
		}
		catch(HibernateException he) {
		he.printStackTrace();
	}
	finally {
		HibernateUtil.closeSessionFactory();
	}*/
		
		// =======================HQL SElect Entity query with Named	Params ==================
					try {
						Transaction tx=ses.beginTransaction(); //dummy
						//prepare Query object
						Query<Product> query=ses.createQuery("FROM com.nt.entity.Product WHERE pname IN(:name1,:name2,'Cooler2')");
						//set values to named params
						query.setParameter("name1","Cooler1");
						query.setParameter("name2","Cooler3");
						//execute query
						List<Product> list=query.getResultList();
						//proess reuslt
						list.forEach(System.out::println);
					}//try
					catch(HibernateException he) {
						he.printStackTrace();
					}
					
					  finally { 
						  HibernateUtil.closeSessionFactory();
						  }
					 
	}//main
}//class
