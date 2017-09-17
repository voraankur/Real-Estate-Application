package com.neu.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.DAO.UserDAO;
import com.neu.exception.AdException;
import com.neu.pojo.User;

@Controller
public class AdminController {

	@RequestMapping(value="/showAdmin.htm",method = RequestMethod.POST)
	public ModelAndView getProducts(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("inside admin controller");
		UserDAO users=null;
  		List usersList = null;
        List userList = new ArrayList();

        try {
         users = new UserDAO();
            usersList = users.list();
            System.out.println("inside admin controller try block");

            Iterator propIterator = usersList.iterator();

                while (propIterator.hasNext())
                {
                	User user = (User)propIterator.next();
                    //Property property = (Property) propIterator.next();
                    //propList.add(property);
                    userList.add(user);
                
            }
            //DAO.close();
        } 
        catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("showUsers", "users", userList);
        return mv;

		
	}
}
