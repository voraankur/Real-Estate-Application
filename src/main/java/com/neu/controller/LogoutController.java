package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("/")
public class LogoutController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//int i=9;
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String home(HttpServletRequest hsr) {
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		HttpSession session = hsr.getSession();
		session.invalidate();
		System.out.println("session is "+ hsr.getSession().getAttribute("username"));
		return "index";
	}
	
	
}
