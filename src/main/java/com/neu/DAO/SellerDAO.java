package com.neu.DAO;

import org.hibernate.HibernateException;

import com.neu.exception.AdException;
//import com.neu.pojo.Email;
import com.neu.pojo.Seller;

public class SellerDAO extends DAO {
	public Seller create(String username, String password,String emailId, String firstName, String lastName)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            //Email email=new Email(emailId);
            Seller seller=new Seller(username,password);
            
            seller.setFirstName(firstName);
            seller.setLastName(lastName);
            
            seller.setEmail(emailId);
            
            //email.setUser(user);
            
            getSession().save(seller);
            
            commit();
            return seller;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
}
