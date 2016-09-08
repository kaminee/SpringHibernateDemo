package com.journaldev.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import com.journaldev.spring.dao.UserDAO;
import com.journaldev.spring.model.Country;
import com.journaldev.spring.model.Group;
import com.journaldev.spring.model.User;

public class Main {
	@Autowired
	private static UserDAO userDao;
	
	  private static final SessionFactory sessionFactory = buildSessionFactory();

    
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure()
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void main(String[] args) {
    	 
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
 
        
    /*    Meeting meeting1 = new Meeting("Quaterly Sales meeting");
        Meeting meeting2 = new Meeting("Weekly Status meeting");
        
        Employee employee1 = new Employee("Kaminee", "Brin");
//        Employee employee2 = new Employee("Larry", "Page");

        employee1.getMeetings().add(meeting1);
        employee1.getMeetings().add(meeting2);
        employee2.getMeetings().add(meeting1);
        
        session.save(employee1);
//        session.save(employee2);
*/        
     /*   Country c=new Country();
        c.setCountryId(1);
        Group groupAdmin = new Group("Test Group");
//        User newUser=userDao.findById(13);
        User user1 = new User();
        user1.setId(15); //        user1.setUsername("HImanci"); //        user1.setEmail("him@mail.com");
        user1.setCountry(c); //        user1.getGroups().add(groupAdmin);
        
        
        groupAdmin.getUsers().add(user1);
         session.save(groupAdmin);
        */
        
       /* User user = (User) session.get(User.class, 15);
        Group grp = (Group) session.get(Group.class, 25l);
        List<User> listUser = session.createCriteria(User.class).list();

        System.out.println("\n\t -"+listUser.size());
        //        listUser.forEach(System.out::println);
        System.out.println("\n\t ===user==>"+user.getUsername()+"\t =="+grp.getUsers());*/
        
//        groupAdmin.addUser(user1);
        Group groupAdmin = new Group();
        groupAdmin.setId(25);
        groupAdmin.setName("Kaminee Grp");
        Country c=new Country();
        c.setCountryId(1);
         Set<User> userList=new HashSet<User>();
         User user1 = new User();
         user1.setId(3); //        user1.setUsername("HImanci"); //        user1.setEmail("him@mail.com");
         user1.setCountry(c); //   
      
         
         User user2 = new User();
         user2.setId(5); //        user1.setUsername("HImanci"); //        user1.setEmail("him@mail.com");
         user2.setCountry(c); //   
         groupAdmin.getUsers().add(user1);
         groupAdmin.getUsers().add(user2);

         session.update(groupAdmin);
        session.getTransaction().commit();
        session.close();
    }
}