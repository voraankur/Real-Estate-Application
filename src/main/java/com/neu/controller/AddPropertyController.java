package com.neu.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.DAO.PropertyDAO;
import com.neu.DAO.UserDAO;
import com.neu.exception.AdException;
import com.neu.pojo.Property;
import com.neu.pojo.User;

@Controller
//@RequestMapping("/addproperty.htm")

public class AddPropertyController {
	@Autowired
	@Qualifier("propertyValidator")
	PropertyValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
/*
	@RequestMapping(value="/addproperty.htm",method = RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest hsr, @ModelAttribute("property") Property property, BindingResult result) throws Exception {
		validator.validate(property, result);
		
		System.out.println("In post method of add property");
		
		if (result.hasErrors()) {
			return "Seller";
		}
		
		try {
			System.out.print("inside try block of addproperty controller");
			PropertyDAO propertyDao= new PropertyDAO();
			//UserDAO userDao = new UserDAO();
			System.out.println("Property DAO created successfully");
			
			String price=hsr.getParameter("price");
			String area=hsr.getParameter("area");
			String propertyType=hsr.getParameter("propertyType");
			String noOfBeds=hsr.getParameter("noOfBeds");
			String noOfBathrooms=hsr.getParameter("noOfBathrooms");
			String zipcode=hsr.getParameter("zipcode");
			String streetName=hsr.getParameter("streetName");
			String city=hsr.getParameter("city");
			String status="Available";
			String user= (String) hsr.getSession().getAttribute("username");
			
			//String owner = user.getFirstName()+" "+user.getLastName();
			
			System.out.println("Price: "+price);
			
			propertyDao.create(price,propertyType,noOfBeds,noOfBathrooms,area,user,
					zipcode,streetName,city,status);
			
			propertyDao.create(property.getPrice(),property.getPropertyType(),
					property.getNoOfBeds(), property.getNoOfBathrooms(), 
					property.getArea());
			//userDao.create(user.getUsername(), user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getUsertype());
			
			
			// DAO.close();
		} catch (AdException e) {
			
			System.out.println("Exception: " + e.getMessage());
		}
		
		return "addedProperty";
	}
*/	
// validation 
	@RequestMapping(value="/addproperty.htm",method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("property")Property property,BindingResult result,HttpServletRequest hsr, HttpServletResponse res) throws Exception{

  validator.validate(property, result);
  if(result.hasErrors())
  {
   return "Seller";
  }
     
  String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
  String STRING_PATTERN = "[a-zA-Z]+";
  String Number_PATTERN = "[0-9]+";
  String STRING_Number = "[a-zA-Z0-9]+";
  
      //  String username = property.getPostedBy();   //get posting user from addAdvertForm
     //   String categoryTitle = property.getCategory_name();   //get category user from addAdvertForm
        String propType=property.getPropertyType();
        String area=property.getArea();
        String bath=property.getNoOfBathrooms();
        String bed=property.getNoOfBeds();
        String price=property.getPrice();
        String zip=hsr.getParameter("zipcode");
        String city=hsr.getParameter("city");
        String street=hsr.getParameter("streetName");
        String status="Available";
        String postedBy= (String) hsr.getSession().getAttribute("username");
        Pattern pattern;
        Matcher matcher;
  
        if (!(zip != null && zip.isEmpty())) { 
          pattern = Pattern.compile(regex);
         matcher = pattern.matcher(zip);        
            if (!matcher.matches()) {  
            System.out.println("Enter valid zip code");
            res.getWriter().println("<html>alert()</html>");
             return  "Seller";
        }
        }
            if (!(city != null && city.isEmpty())) { 
             pattern = Pattern.compile(STRING_PATTERN);
            matcher = pattern.matcher(city);
               if (!matcher.matches()) {  
               System.out.println("Enter valid city name");
                return  "Seller";
           }
            }
               if (!(street != null && street.isEmpty())) { 
                   pattern = Pattern.compile(STRING_Number);
                  matcher = pattern.matcher(street);
                     if (!matcher.matches()) {  
                     System.out.println("Enter valid street name");
                      return  "Seller";
                 }
               }
                     if (!(price != null && price.isEmpty())) { 
                       pattern = Pattern.compile(Number_PATTERN);
                      matcher = pattern.matcher(price);
                         if (!matcher.matches()) {  
                         System.out.println("Enter valid value for price");
                          return  "Seller";
                     }
                         if (!(area != null && area.isEmpty())) { 
                           pattern = Pattern.compile(STRING_Number);
                          matcher = pattern.matcher(area);
                             if (!matcher.matches()) {  
                             System.out.println("Enter valid sq feet area");
                              return  "Seller";
                         }
                         }
        //get user message from addAdvertForm
      
      }
        try {
        UserDAO users=new UserDAO();
        //User user = users.get(postedBy);
           // SellerDAO seller = new SellerDAO();
       //     CategoryDAO categories = new CategoryDAO();
            PropertyDAO properties = new PropertyDAO();

            //searching from database
//           User user = users.get(username);

            //insert a new property
          properties.create(area,bed,bath,propType, price,status,postedBy,zip,city,street);
          
          //  Property prop=properties.create(bed,bath,price, area, users);

            
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        return "addedProperty";
    }
	// validation ends
	
	@RequestMapping(value="/showownerprop.htm",method = RequestMethod.POST)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //CategoryDAO categories = null;
        //List categoryList = null;
  PropertyDAO properties=null;
  		List propertyList = null;
        List propList = new ArrayList();
        String user= (String) request.getSession().getAttribute("username");

        try {
        	
         properties = new PropertyDAO();
            propertyList = properties.listByOwner(user);

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

        ModelAndView mv = new ModelAndView("Seller", "searchProperties", propList);
        return mv;
    }

	
	@RequestMapping(method = RequestMethod.GET)
	protected String initializeForm(@ModelAttribute("property") Property property, BindingResult result) throws Exception {
	return "Seller";	
	}
	
}

