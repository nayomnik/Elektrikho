/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uz.uliktrik.gushkunakho;

import uz.uliktrik.amborho.UliktrichoDB;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceUnit;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import uz.uliktrik.servletho.l;

/*
 * Copyright 2007 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */




public final class ContextGushkunak implements ServletContextListener {
//    @PersistenceUnit
//    private EntityManagerFactory mEntityManagerFactory;
    private ServletContext context = null;

    public void contextInitialized(ServletContextEvent event) {
        context = event.getServletContext();

    	String url = context.getInitParameter("url");
        String user_name = context.getInitParameter("user_name");
    	String password = context.getInitParameter("password");
    	String database = context.getInitParameter("database");
    	
//        Counter counter = new Counter();
//        context.setAttribute("hitCounter", counter);
//        counter = new Counter();
//        context.setAttribute("orderCounter", counter);

        try {
            l.a(" contextInitialized");
            UliktrichoDB uliktrichoDBLcl = new UliktrichoDB(url + database,"samadjon", password);
    	//System.out.println("in the listener!!");
            context.setAttribute("ELEKTRIKHO", uliktrichoDBLcl);
        } catch (Exception ex) {
            System.out.println(
                    "Couldn't create ELEKTRIKHO database bean: "
                    + ex.getMessage());
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        context = event.getServletContext();
//        context.removeAttribute("hitCounter");
//        context.removeAttribute("orderCounter");
//
        UliktrichoDB uliktrichoDBLcl = (UliktrichoDB) context.getAttribute("ELEKTRIKHO");

        if (uliktrichoDBLcl != null) {
            uliktrichoDBLcl.remove();
        }
//
//        context.removeAttribute("bookDB");
    }
}
