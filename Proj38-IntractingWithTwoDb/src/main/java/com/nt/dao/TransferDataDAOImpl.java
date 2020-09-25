package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.MysqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class TransferDataDAOImpl implements TransferDataDAO {
  
	@Override
	public String transferProductById(int pid) {
		Session sesOra=null,sesMysql=null;
		Transaction oraTx=null,mysqlTx=null;
		Product prod=null;
		var idVal=0;
		var flag=false;
       //get both session objects
		sesOra=OracleHibernateUtil.getSession();
		sesMysql=MysqlHibernateUtil.getSession();
		//load product from db 
		  oraTx=sesOra.beginTransaction();
		  prod=sesOra.get(Product.class, pid);
		  if(prod==null) {
			  return "no record found";
		  }
		  else {
			  try {
				  mysqlTx=sesMysql.beginTransaction();
				  idVal=(int) sesMysql.save(prod);
				  flag=true;
			  }
			  catch(HibernateException he) {
				  he.printStackTrace();
				  flag=false;
			  }
			  finally {
				  if(flag) {
					  mysqlTx.commit();
					  return "record copied from oracle DB to mysql DB having idVal::"+idVal;
				  }
				  else {
					  mysqlTx.rollback();
					  return "record not copied from oracle Db to Mysql DB::";
				  }
			  }
		  }
	}

}
