package com.nt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nt.utility.HibernateUtil;

public class SessionFactoryClosingContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	System.out.println("SessionFactoryClosingContextListener.contextDestroyed()");
    	HibernateUtil.closeSessionFactory();
    }
}
