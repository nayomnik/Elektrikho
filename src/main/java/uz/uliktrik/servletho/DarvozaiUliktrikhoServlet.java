/*
 * Copyright 2007 Sun Microsystems, Inc.
 * All rights reserved.  You may not modify, use,
 * reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://developer.sun.com/berkeley_license.html
 */


package uz.uliktrik.servletho;

import uz.uliktrik.amborho.UliktrichoDB;
import uz.uliktrik.istisnoho.UliktricIstisno;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

import java.sql.*;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 * This is a simple example of an HTTP Servlet.  It responds to the GET
 * method of the HTTP protocol.
 */
public class DarvozaiUliktrikhoServlet extends HttpServlet {
    private UliktrichoDB mUliktrichoDB;
    @Override
    public void init() throws ServletException {
        ResultSet resultSetLcl=null;
        try {
            l.a("init()");
            mUliktrichoDB = (UliktrichoDB)getServletContext().
                    getAttribute("ELEKTRIKHO");
            resultSetLcl= mUliktrichoDB.nomhoyaTe();
            char[] harfoLcl=new char[40];
            while(resultSetLcl.next())
                 l.b(resultSetLcl.getString("NOM")+66);
            resultSetLcl= mUliktrichoDB.telhoyaTe();
            while(resultSetLcl.next())
                 l.b(resultSetLcl.getString("telho"));
            if (mUliktrichoDB == null) throw new
                    UnavailableException("Couldn’t get database.");
        } catch (UliktricIstisno ex) {
            l.a(11);
            ex.printStackTrace();
            Logger.getLogger(DarvozaiUliktrikhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            l.a(22);
            ex.printStackTrace();
            Logger.getLogger(DarvozaiUliktrikhoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) 
            throws ServletException, IOException {
        l.a(8768);
//        request.
//            new TestCreateDBClass();
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();

        // then write the data of the response
        out.println("<html>" + "<head><title>Hello</title></head>");

        // then write the data of the response
        out.println(
                "<body  bgcolor=\"#ffffff\">"
                + "<img src=\"duke.waving.gif\" alt=\"Duke waving\">"
                + "<h2>Hello, my name is Duke. What's yours?</h2>"
                + "<form method=\"get\">"
                + "<input type=\"text\" name=\"username\" size=\"25\">"
                + "<p></p>" + "<input type=\"submit\" value=\"Submit\">"
                + "<input type=\"reset\" value=\"Reset\">" + "</form>");

        String username = request.getParameter("username");

        if ((username != null) && (username.length() > 0)) {
            RequestDispatcher dispatcher = getServletContext()
                                               .getRequestDispatcher(
                        "/response");

            if (dispatcher != null) {
                dispatcher.include(request, response);
            }
        }

        out.println("</body></html>");
        out.close();
//        List<String> o=null;
//        try{
//            o.toString();
//        }catch(Exception e){
//            
//        }
//this
    }

    @Override
    public String getServletInfo() {
        this.log("getServletInfo getServletInfo getServletInfo getServletInfo");
        l.a("getServletInfo getServletInfo getServletInfo getServletInfo");
        return "The Hello servlet says: \"hello.\"";
    }
}
