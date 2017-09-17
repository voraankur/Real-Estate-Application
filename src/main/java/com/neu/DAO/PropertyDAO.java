package com.neu.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.AdException;
import com.neu.pojo.Address;
//import com.neu.pojo.Email;
import com.neu.pojo.Property;

public class PropertyDAO extends DAO {
	public Property create(String price,String propertyType, String noOfBeds,
			String noOfBathrooms, String area, String owner,
			String zipcode, String streetName,
			String city,String status)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            Address address = new Address(streetName,city,zipcode);
            //Email email=new Email(emailId);
            Property property = new Property(price,propertyType,noOfBeds,noOfBathrooms,area,owner,status);
            System.out.println("Property object created");
            //Buyer buyer=new Buyer(username,password);
            
            //buyer.setFirstName(firstName);
            //buyer.setLastName(lastName);
            address.setCity(city);
            address.setStreetName(streetName);
            address.setZipCode(zipcode);
            //buyer.setEmail(emailId);
            
            //email.setUser(user);
            property.setPropertyType(propertyType);
            property.setNoOfBathrooms(noOfBathrooms);
            property.setNoOfBeds(noOfBeds);
            property.setArea(area);
            property.setPrice(price);
            //property.setZipcode(zipcode);
            property.setStatus(status);
            
            property.setAddress(address);
            address.setProperty(property);
            
            //String owner="1";
            property.setOwner(owner);
            
            getSession().save(property);
            
            commit();
            return property;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
	
	public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Property");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the properties", e);
        }
    }
	
	
	
	public List listByOwner(String user) throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Property where owner=:user");
            q.setString("user", user);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the properties", e);
        }
    }
	
	public List searchByPin(String zipCode) throws AdException {
        try {
            begin();
            //String hql="Select * from Property where zipcode like :zipCode";
            System.out.println("inside search by zipcode function");
            Query q = getSession().createQuery("from Address where zipCode=:zipCode");
            System.out.println(q);
            q.setString("zipCode",zipCode);
            //q.setString("avail", "Available");
            System.out.println(q);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the properties", e);
        }
    }
	
	public List searchById(long propID) throws AdException {
        try {
            begin();
            //String hql="Select * from Property where zipcode like :zipCode";
            System.out.println("inside search by prop id function");
            Query q = getSession().createQuery("from Property where propertyID=:propID");
            System.out.println(q);
            System.out.println("property id is :  "+propID);
            //String proppID = String.valueOf(propID);
            //q.setString("propID",proppID);
            q.setLong("propID", propID);
            //q.setString("avail", "Available");
            System.out.println("full query"+q);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the properties", e);
        }
    }
	

	public String markComplete(String propertyId, String username) throws AdException {
            try {
                begin();
//              Long  userId = user.getPersonID();
              

              //Long taskID = Long.parseLong(taskId);
                Query q = getSession().createQuery("update Property set status=:status, newOwner=:username where propertyID =:propertyId ");
//                q.setLong("tasker",user.getPersonID());
                q.setString("username", username);
                q.setString("status","Sold");
                q.setString("propertyId",propertyId);
                //q.setLong("taskID",taskID);
               int i= q.executeUpdate();
               commit();
                close();
               if (i>0){
                   
                   return "success";
               }
               else{
                   return "";
               }
//                List list = q.list();
                
//                return list;
            } catch (HibernateException e) {
                rollback();
                throw new AdException("Could not process the request", e);
            }
        }
	
	public String markComplete1(String propertyId) throws AdException {
        try {
            begin();
//          Long  userId = user.getPersonID();
          

          //Long taskID = Long.parseLong(taskId);
            Query q = getSession().createQuery("update Property set status=:status, newOwner=:username where propertyID =:propertyId ");
//            q.setLong("tasker",user.getPersonID());
            q.setString("username", "");
            q.setString("status","Available");
            q.setString("propertyId",propertyId);
            //q.setLong("taskID",taskID);
           int i= q.executeUpdate();
           commit();
            close();
           if (i>0){
               
               return "success";
           }
           else{
               return "";
           }
//            List list = q.list();
            
//            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not process the request", e);
        }
    }
	
	public String deleteProp(String propertyId) throws AdException {
        try {
            begin();
//          Long  userId = user.getPersonID();
          

          //Long taskID = Long.parseLong(taskId);
            Query q = getSession().createQuery("delete from Address where propertyID =:propertyId ");
            Query q1 = getSession().createQuery("delete from Property where propertyID =:propertyId ");
//            q.setLong("tasker",user.getPersonID());
            //q.setString("username", "");
            //q.setString("status","Available");
            q.setString("propertyId",propertyId);
            q1.setString("propertyId",propertyId);
            //q.setLong("taskID",taskID);
           int i= q.executeUpdate();
           int i1=q1.executeUpdate();
           commit();
           close();
           if (i>0 && i1>0){
            		   return "success";
           }
           else{
               return "";
           }
//            List list = q.list();
            
//            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete from Address", e);
        }
    }
	
}
