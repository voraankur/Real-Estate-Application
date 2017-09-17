package com.neu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.neu.DAO.UserDAO;
import com.neu.exception.AdException;
import com.neu.pojo.User;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	@Autowired
	@Qualifier("loginValidator")
	LoginValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest hsr, @ModelAttribute("user") User user, BindingResult result) throws Exception {
		validator.validate(user, result);
		
		System.out.println("In post method of login user");
		
		if (result.hasErrors()) {
			return "loginForm";
		}

		try {
			System.out.print("inside try block of login controller");
			UserDAO userDAO = new UserDAO();

			User user1 = userDAO.get(user.getUsername()); 
			
			if (user1 != null)
			{
				System.out.println("User present in db");
				String pswd=userDAO.matchPassword(user.getUsername());
				System.out.println("db password " + pswd);
				System.out.println("entered password "+ user.getPassword());
				if(pswd.equals(user.getPassword()))
				{
					System.out.println("username and password matched");
				}
				else
				{
					System.out.println("Invalid password");
					
					return "loginForm";
				}
			}
			else
			{
				System.out.println("Kindly register");
				return "addUserForm";
			}
			
			System.out.println("DAO created successfully");
			System.out.print("test1");
			
			hsr.getSession().setAttribute("user", user1);
			System.out.println("user type is "+user1.getUsertype());
			hsr.getSession().setAttribute("username", user.getUsername());
			
				
				if(user1.getUsertype().equals("buyer")){
					return "Buyer";
				}
				else if(user1.getUsertype().equals("seller"))
				{
					System.out.println("Login Controller Seller");
					return "Seller";
				}
				else if(user1.getUsertype().equals("admin"))
				{
					System.out.println("Login Controller Admin");
					return "Admin";
				}
			
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "index";
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "loginForm";
	}
	
}