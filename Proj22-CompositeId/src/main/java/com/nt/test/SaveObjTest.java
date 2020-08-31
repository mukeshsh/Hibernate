package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.ProgrammerProjId;
import com.nt.entity.ProgrammerProjInfo;
import com.nt.utility.HibernateUtil;

public class SaveObjTest {

	public static void main(String[] args) {
      Session session=null;
      Transaction tx=null;
      ProgrammerProjId id=null;
      ProgrammerProjInfo info=null;
      boolean flag=false;
		//get Session
      session=HibernateUtil.getSession();
      try {
    	  //begin tx
    	  tx=session.beginTransaction();
    	  //Prepare Entity object
    	  id=new ProgrammerProjId();
    	  id.setPid(1002);
    	  id.setProjId(5001);
    	  info=new ProgrammerProjInfo();
    	  info.setId(id);
    	  info.setPname("Shreya");
    	  info.setProjName("OpenFx1");
    	  info.setDeptNo(202);
    	  //save obje
    	  id=(ProgrammerProjId) session.save(info);
    	  System.out.println("Generated Id values::"+id);
    	  flag=true;
      }
      catch(HibernateException he) {
    	  flag=false;
    	  he.printStackTrace();
      }
      catch(Exception e) {
    	  flag=false;
    	  e.printStackTrace();
      }
      finally {
    	  if(flag) {
    		  tx.commit();
    	  System.out.println("Object Saved");
    	  }
    	  else {
    		  tx.rollback();
    	  System.out.println("Object Not found");
    	  }
    	  HibernateUtil.closeSession(session);
    	  HibernateUtil.closeSessionFactory();
      }
	}

}
