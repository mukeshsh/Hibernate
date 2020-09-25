package com.nt.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import com.nt.utility.HibernateUtil;

public class SessionClosingServletRequestListener implements ServletRequestListener {
    
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("SessionClosingServletRequestListener.requestDestroyed()");
		HibernateUtil.closeSession();
	}
}
