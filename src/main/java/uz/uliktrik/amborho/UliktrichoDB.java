/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uz.uliktrik.amborho;

import uz.uliktrik.istisnoho.UliktricIstisno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.sun.bookstore.cart.ShoppingCart;
//import com.sun.bookstore.cart.ShoppingCartItem;
//import com.sun.bookstore.database.Book;
//import com.sun.bookstore.exception.BookNotFoundException;
//import com.sun.bookstore.exception.BooksNotFoundException;
//import com.sun.bookstore.exception.OrderException;
import javax.persistence.*;
import uz.uliktrik.servletho.l;


/**
 *
 * @author User
 */
public class UliktrichoDB {
        private ArrayList uliktricho;
    private EntityManager mEntityManager;
    private Connection payvandchi;

    public UliktrichoDB(EntityManagerFactory entityManagerFactoryPrm) throws Exception {
        mEntityManager = entityManagerFactoryPrm.createEntityManager();

        try {
        } catch (Exception ex) {
            throw new Exception(
                    "Couldn't open connection to database: " + ex.getMessage());
        }
    }

    public UliktrichoDB(String url, String user_name, String password) {
        try {
//			Class.forName("com.mysql.jdbc.Driver");
 
			payvandchi = DriverManager.getConnection(url, user_name, user_name);
 
        } catch (SQLException e) {
			// TODO Auto-generated catch block
                        l.a("Error in public UliktrichoDB ");
			e.printStackTrace();
		}
	}

    public void remove() {
        try {
            payvandchi.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
//
    public ResultSet nomhoyaTe() throws UliktricIstisno{
                return sqlKor("SELECT  NOM FROM ELEKTRIKHO ORDER BY ELEKTRIKHO.ID");
    }
    public ResultSet telhoyaTe() throws UliktricIstisno{
                return sqlKor("SELECT  telho FROM ELEKTRIKHO ORDER BY ELEKTRIKHO.ID");
    }
    
    private ResultSet sqlKor(String sqlPursishPrm) throws UliktricIstisno {
        try {
           return  payvandchi.createStatement().executeQuery(sqlPursishPrm);
        } catch (Exception ex) {
            throw new UliktricIstisno(
                    "Could not get books: " + ex.getMessage());
        }
    }
//
//    public Book getBook(String bookId) throws BookNotFoundException {
//        Book requestedBook = em.find(Book.class, bookId);
//
//        if (requestedBook == null) {
//            throw new BookNotFoundException("Couldn't find book: " + bookId);
//        }
//
//        return requestedBook;
//    }
//
//    public void buyBooks(ShoppingCart cart) throws OrderException {
//        Collection items = cart.getItems();
//        Iterator i = items.iterator();
//
//        try {
//            while (i.hasNext()) {
//                ShoppingCartItem sci = (ShoppingCartItem) i.next();
//                Book bd = (Book) sci.getItem();
//                String id = bd.getBookId();
//                int quantity = sci.getQuantity();
//                buyBook(id, quantity);
//            }
//        } catch (Exception ex) {
//            throw new OrderException("Commit failed: " + ex.getMessage());
//        }
//    }
//
//    public void buyBook(
//        String bookId,
//        int quantity) throws OrderException {
//        try {
//            Book requestedBook = em.find(Book.class, bookId);
//
//            if (requestedBook != null) {
//                int inventory = requestedBook.getInventory();
//
//                if ((inventory - quantity) >= 0) {
//                    int newInventory = inventory - quantity;
//                    requestedBook.setInventory(newInventory);
//                } else {
//                    throw new OrderException(
//                            "Not enough of " + bookId
//                            + " in stock to complete order.");
//                }
//            }
//        } catch (Exception ex) {
//            throw new OrderException(
//                    "Couldn't purchase book: " + bookId + ex.getMessage());
//        }
//    }
}

