package com.neu.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.AdException;
import com.neu.pojo.Email;
//import com.neu.pojo.Email;
import com.neu.pojo.User;


public class UserDAO extends DAO {
	
	
	public User get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
	
	public String matchPassword(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createSQLQuery("Select password from user where username=:username");
            q.setString("username", username);
            String pswd = q.uniqueResult().toString();
            //User user = (User) q.uniqueResult();
            commit();
            return pswd;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
	
	public User create(String username, String password,String emailId, String firstName, String lastName, String userType)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            Email email=new Email(emailId);
            User user=new User(username,password, userType);
            
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsertype(userType);
            
            user.setEmail(email);
            
            email.setUser(user);
            
            getSession().save(user);
            System.out.println("user added in db");
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public List list() throws AdException {
        try {
        	System.out.println("user list() method");
            begin();
            Query q = getSession().createQuery("from User where usertype!=:admin");
            q.setString("admin", "admin");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the users", e);
        }
    }
}
