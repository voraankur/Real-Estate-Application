package com.neu.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neu.DAO.PropertyDAO;
import com.neu.exception.AdException;
import com.neu.pojo.Address;
import com.neu.pojo.Property;
import com.neu.pojo.User;

@Controller
//@RequestMapping("/listprop.htm")
public class ListPropertiesController{

 @RequestMapping(value="/listprop.htm",method=RequestMethod.POST)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //CategoryDAO categories = null;
        //List categoryList = null;
	 	PropertyDAO properties=null;
  		List propertyList = null;
        List propList = new ArrayList();

        User userObj=(User)request.getSession().getAttribute("user");
        System.out.println("User type is  "+ userObj.getUsertype());
        String username = (String) request.getSession().getAttribute("username");
        try {
         properties = new PropertyDAO();
            propertyList = properties.list();

            Iterator propIterator = propertyList.iterator();

                while (propIterator.hasNext())
                {
                    Property property = (Property) propIterator.next();
                    propList.add(property);
                
            }
            //DAO.close();
        } 
        catch (AdException e) {
            System.out.println(e.getMessage());
        }

        if(userObj.getUsertype().equals("admin")){
        	ModelAndView mv = new ModelAndView("AllProperties", "properties", propList);
            return mv;
        }
        else{
        ModelAndView mv = new ModelAndView("showProperties", "properties", propList);
        return mv;
        }
    }
 
 //int count=0;
 @RequestMapping(value="/searchprop.htm",method=RequestMethod.POST)
 protected ModelAndView handleRequestInternal1(HttpServletRequest request, HttpServletResponse response) throws Exception {
     //CategoryDAO categories = null;
     //List categoryList = null;
	 //	count++;
	 	PropertyDAO properties=null;
		List propertyList = null;
		ModelAndView mv=new ModelAndView();
     List propList = new ArrayList();
     String zipCode=request.getParameter("zipCode");

     /*if(count==1){
    	 ModelAndView mv1=new ModelAndView("Buyer", "proplist", propList);
    	 return mv1;
     }*/
     try {
    	 properties = new PropertyDAO();
         propertyList = properties.searchByPin(zipCode);

         Iterator propIterator = propertyList.iterator();

             while (propIterator.hasNext())
             {
            	 Address property = (Address) propIterator.next();
                 //Property property = (Property) propIterator.next();
                 propList.add(property);
             
         }
         mv.addObject("searchProperties", propList);
         //DAO.close();
     } 
     catch (AdException e) {
         System.out.println(e.getMessage());
     }

     mv.setViewName("Buyer");
     //ModelAndView mv = new ModelAndView("showProperties", "properties", propList);
     return mv;
     
 }
 
 @RequestMapping(value="/searchprop1.htm*",method=RequestMethod.GET)
 public ModelAndView handleRequestInternal2(HttpServletRequest request) throws Exception {
     //CategoryDAO categories = null;
     //List categoryList = null;
	 //	count++;
	  String zipcode = request.getParameter("zipcode");
	 System.out.println("inside search in controller "+ zipcode);
	 	PropertyDAO properties=null;
		List propertyList = null;
		ModelAndView mv=new ModelAndView();
     List propList = new ArrayList();
     //String zipCode=request.getParameter("zipCode");
     //String zipCode="02120";
     System.out.println("Zipcode is "+ zipcode);
     /*if(count==1){
    	 ModelAndView mv1=new ModelAndView("Buyer", "proplist", propList);
    	 return mv1;
     }*/
     try {
    	 properties = new PropertyDAO();
         propertyList = properties.searchByPin(zipcode);
         System.out.println("List size mila "+propertyList.size());

         Iterator propIterator = propertyList.iterator();

             while (propIterator.hasNext())
             {
            	 Address property = (Address) propIterator.next();
                 //Property property = (Property) propIterator.next();
                 propList.add(property);
             
         }
         mv.addObject("properties", propList);
         //DAO.close();
     } 
     catch (AdException e) {
         System.out.println(e.getMessage());
     }

     mv.setViewName("showPropertiesfromHome");
     //ModelAndView mv = new ModelAndView("showProperties", "properties", propList);
     return mv;
     
 }
 
 
 @RequestMapping(value={"/markComplete.htm"})
 public @ResponseBody String markComplete(HttpServletRequest hsr ) throws AdException {
  HttpSession session = hsr.getSession(false);
  //User user = (User) session.getAttribute("user");
  //hsr.getSession().setAttribute("sold", );
  String username = (String) hsr.getSession().getAttribute("username");
  String propertyID = hsr.getParameter("propertyID");
  PropertyDAO prop = new PropertyDAO();
  return prop.markComplete(propertyID, username);
  
 }
 
 @RequestMapping(value={"/markComplete1.htm"})
 public @ResponseBody String markComplete1(HttpServletRequest hsr ) throws AdException {
  HttpSession session = hsr.getSession(false);
  //User user = (User) session.getAttribute("user");
  //hsr.getSession().setAttribute("sold", );
  String username = (String) hsr.getSession().getAttribute("username");
  String propertyID = hsr.getParameter("propertyID");
  PropertyDAO prop = new PropertyDAO();
  return prop.markComplete1(propertyID);
 }
 
 @RequestMapping(value={"/deleteProp.htm"})
 public @ResponseBody String deleteProp(HttpServletRequest hsr ) throws AdException {
  HttpSession session = hsr.getSession(false);
  //User user = (User) session.getAttribute("user");
  //hsr.getSession().setAttribute("sold", );
  String username = (String) hsr.getSession().getAttribute("username");
  String propertyID = hsr.getParameter("propertyID");
  System.out.println("PropertyID is "+propertyID);
  PropertyDAO prop = new PropertyDAO();
  return prop.deleteProp(propertyID);
 }
 
 
 @RequestMapping(value="/viewDetails.htm*",method=RequestMethod.GET)
 public ModelAndView viewPropertyDetails(@RequestParam int propId) throws AdException{
	 //long propID = Long.parseLong(hsr.getParameter("data"));
	 
	 System.out.println("Property ID : " + propId  );
	 PropertyDAO properties = null;
	 Property property;
	List propertyList = null;
		ModelAndView mv=new ModelAndView();
  List propList = new ArrayList();
	 try {
         properties = new PropertyDAO();
         propertyList = properties.searchById(propId);
         System.out.println("size is "+propertyList.size());
            Iterator propIterator = propertyList.iterator();

                while (propIterator.hasNext())
                {
                    Property property1 = (Property) propIterator.next();
                    propList.add(property1);
                
            }
            //DAO.close();
        } 
        catch (AdException e) {
            System.out.println(e.getMessage());
        }
	 mv.addObject("searchProperties", propList);
	 mv.setViewName("showPropDetails");
	 return mv;
 }
 
}