package com.journaldev.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.dao.CountryDao;
import com.journaldev.spring.dao.UserDAO;
import com.journaldev.spring.model.Country;
import com.journaldev.spring.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserDAO userDao;
	
//	@Autowired
//	@Qualifier("userB")
//	private User user;
	
	@Autowired
	private CountryDao countryDao;
	
	
	@Autowired
//	@Qualifier("userA")
//	private User userA;
//	@Autowired
//	private UserDAO userDao1;
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		System.out.println("\t home page \t\n");
		List<User> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("home");
		model.addObject("userList", listUsers);
		return model;
	}
	
	@RequestMapping(value="/showUsers")
	 public ModelAndView fetchProfileMatch() {
		
		 List<User> listUsers = userDao.list();
			ModelAndView model = new ModelAndView("show-users");
			model.addObject("userList", listUsers);
			System.out.println("\n\t -----listUsers---------->"+listUsers.size());
		 return new ModelAndView("", "responseObject", listUsers);
		 
	 }
	
	
	
	@RequestMapping(value = "/mobile", method = RequestMethod.GET)
	@ResponseBody
	public List<User>  listforCompanies() {      
		List<User> listUsers = userDao.list();
	    return listUsers;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<User>  listOfUsers() {      
		List<User> listUsers = userDao.list();
	    return listUsers;
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	@ResponseBody
	public List<Country>  listOfCo() {      
		List<Country> listUsers = countryDao.fetchAllCountries();
	    return listUsers;
	}
}
