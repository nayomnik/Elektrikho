/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uz.uliktrik.istisnoho;

/**
 *
 * @author User
 */
    
import uz.uliktrik.servletho.l;


/** This application exception indicates that a book
 *  has not been found.
 */
public class UliktricIstisno 
 extends Exception {
    public UliktricIstisno() {
        l.a("Ro'yxat yof nashudas.");
    }

    public UliktricIstisno(String msg) {
        super(msg);
    }
}