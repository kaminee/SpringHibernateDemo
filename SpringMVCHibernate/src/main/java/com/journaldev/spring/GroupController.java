package com.journaldev.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.journaldev.spring.dao.GroupDAO;
import com.journaldev.spring.dao.UserDAO;
import com.journaldev.spring.model.Country;
import com.journaldev.spring.model.Group;
import com.journaldev.spring.model.User;

/**
 * Handles requests for the application home page.
 */
@RequestMapping(value = "/group")
@Controller
public class GroupController {
	
	@Autowired
	private GroupDAO groupDAO;
	
	@Autowired
	private UserDAO userDao1;
	
	private static final Logger logger =LoggerFactory.getLogger(GroupController.class);
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	@ResponseBody
	public List<Group>  listOfGroups() {   
		System.out.println("\n\t ==listOfUsers=");
		List<Group> listGroups = groupDAO.list();
		System.out.println("\n\t ==listOfUsers="+listGroups.size());

	    return listGroups;
	}
	
	 @RequestMapping(method = RequestMethod.GET)
	   public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      System.out.println("lod group ");
	      return "GroupsManagement";
	   }
	 
	 
		
	 @RequestMapping(value = "/usergroups", method = RequestMethod.GET)
	   public String loadUsersGroup(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      System.out.println("lod UserGroupManagement ");
	      return "UserGroupManagement";
	   }
	 
		@RequestMapping(value = "/usergroups/fetch", method = RequestMethod.GET)
		@ResponseBody
		public List<Group>  listOfUserGroups() {   
			System.out.println("\n\t ==listOfUserGroups=");
//			  User newUser=userDao1.findById(3);
			List<Group> listGroups = groupDAO.findAllWithUsers();
			System.out.println("\n\t ==listOfUsers="+listGroups.size());

		    return listGroups;
		}
		
	 
	  @RequestMapping(value = "", method = RequestMethod.POST, produces="application/json",consumes ="application/json")
	    public ResponseEntity<Void> createGroup(@RequestBody Group group,    UriComponentsBuilder ucBuilder,HttpServletRequest request) {
		  System.out.println("\n\n\t ==getUsers=====>"+group.getUsers()+"\t name-"+group.getName()+"\t group-->"+group);		  
		 try{
			 Group groupAdmin =null;
			 int userId=0;
		  for (User userW : group.getUsers()) {
			 userId=userW.getId();
			 groupAdmin = new Group(""+group.getName()+"");
			 User newUser=userDao1.findById(userId);
				System.out.println("\n\t id---"+newUser.getId()+"\t --ctry-->"+newUser.getCountry().getCountryId());
				groupAdmin.getUsers().add(newUser);
				  
		  }
		  groupDAO.saveGroup(groupAdmin);
				  
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 
	        HttpHeaders headers = new HttpHeaders();
//	        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	  
	  
	   @RequestMapping(value = "/group/", method = RequestMethod.GET)
	    public ResponseEntity<List<Group>> listAllUsers() {
		   long startTime=System.currentTimeMillis();
		   System.out.println("\n\t --first time ===>"+System.currentTimeMillis());
	        List<Group> groups = groupDAO.list();
//	        List<Group> user2 = groupDAO.list();
//	        List<Group> user3 = groupDAO.list();
	        System.out.println("\n\t -end-time ===>"+(System.currentTimeMillis()-startTime));
	        if (groups.isEmpty()) {
	            return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Group>>(groups, HttpStatus.OK);
	    }
	   
	   
	    //------------------- Update a User --------------------------------------------------------
	     
	    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Group> updateUser(@PathVariable("id") long id, @RequestBody Group group) {
	        System.out.println("Updating User " + id);
	         
	        Group currentGroup = groupDAO.findById(id);
	        System.out.println("currentUser " + currentGroup+"\t -->"+group.getName());
	        if (currentGroup==null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentGroup.setName(group.getName());
	         
	        groupDAO.updateGroup(currentGroup);
	        return new ResponseEntity<Group>(currentGroup, HttpStatus.OK);
	    }
	    
	    
		 @RequestMapping(value = "/loadUser/{id}", method = RequestMethod.GET)
		   public ResponseEntity<Group> fetchUserById(@PathVariable("id") long id) {
			 Group currentUser = groupDAO.findById(id);
		        if (currentUser==null) {
		            System.out.println("Group with id " + id + " not found");
		            return new ResponseEntity<Group>(HttpStatus.NOT_FOUND);
		        }
		        return new ResponseEntity<Group>(currentUser, HttpStatus.OK);
		   }
		 
		 
		 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		   public ResponseEntity<List<Group>> deleteUserById(@PathVariable("id") int id) {
			 groupDAO.deleteGroupById(id);
		        List<Group> users = groupDAO.list();
		      
		        if(users.isEmpty()){
		            return new ResponseEntity<List<Group>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		        }
		        return new ResponseEntity<List<Group>>(users, HttpStatus.OK);
		   }
}
