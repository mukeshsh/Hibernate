package com.nt.test;

import com.nt.dao.TransferDataDAO;
import com.nt.dao.TransferDataDAOImpl;
import com.nt.utility.MysqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class IntractingWithTwoDBTest {

	public static void main(String[] args) {
		TransferDataDAO dao=null;
		//create DAO
		dao=new TransferDataDAOImpl();
		//invoke methods
		System.out.println(dao.transferProductById(13));
		
		//close SEssion factory
		OracleHibernateUtil.closeSessionFactory();
		MysqlHibernateUtil.closeSessionFactory();
	}//main
}//class
