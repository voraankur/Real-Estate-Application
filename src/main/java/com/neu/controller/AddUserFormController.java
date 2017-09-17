package com.neu.controller;

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
@RequestMapping(value={"/adduser.htm"})
public class AddUserFormController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result) throws Exception {
		validator.validate(user, result);
		
		System.out.println("In post method of add user");
		
		if (result.hasErrors()) {
			return "addUserForm";
		}

		try {
			System.out.print("inside try block of adduserform controller");
			UserDAO userDao = new UserDAO();
			System.out.println("DAO created successfully");
			System.out.print("test1");
			
			userDao.create(user.getUsername(), user.getPassword(), user.getEmail().getEmailId(), user.getFirstName(), user.getLastName(), user.getUsertype());
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		/*if(user.getUsertype().equals("buyer")){
			return "Buyer";
		}*/
		
			return "index";
		
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "addUserForm";
	}
	
}