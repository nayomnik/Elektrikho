/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uz.uliktrik.servletho;

import java.nio.charset.Charset;

/**
 *
 * @author Nayomnik
 */
public  class l {
    static public void a(Object o){
            System.out.println(Charset.forName("UTF-8").encode("iiiiiiiiiiiii ===>   " + o.toString()));
	}
	static public void a(int o){ 
	}
	static public void b(Object o){
            System.out.println("iiiiiiiiiiiii ===>   " + o.toString());
	}
	static public void b(int o){
           String sLcl;
		System.out.println("iiiiiiiiiiiii ===>   " +o);
	}
        static public void pause(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
			try {
				Thread.sleep(i);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
				try {
					Thread.sleep(i);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
