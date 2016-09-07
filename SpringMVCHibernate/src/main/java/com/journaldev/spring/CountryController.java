package com.journaldev.spring;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.journaldev.spring.dao.CountryDao;
import com.journaldev.spring.model.Country;

@RequestMapping(value = "/country")
@Controller
public class CountryController {
	
//	@Autowired
	private CountryDao countryDao;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Country>  listOfCo() {      
		List<Country> listUsers = countryDao.fetchAllCountries();
	    return listUsers;
	}
}
