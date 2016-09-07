package com.journaldev.spring.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.User;

//@Transactional 
@SuppressWarnings("unchecked")
@Component
public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;
	
	private static final Logger logger =LoggerFactory.getLogger(UserDAOImpl.class);

	public UserDAOImpl(){
		
	}
//	private static List<User> users;
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
//	@Cacheable(value = { "users" })
	public List<User> list() {
		logger.info("\n\t sessionFactory=============>"+sessionFactory);
		List<User> listUser = sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		logger.info("\n\t\tuser====listUser==>"+listUser.size());
		return listUser;
	}

	@Override
	@Transactional
	public User findById(long id) {
		logger.info("\n\n\t ----long id-------->"+id);

		List<User> users = sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}

	@Override
	public Optional<User> findByName(String name,List<User> users ) {
		logger.info("find by nsme=="+name);
		
		users.forEach(user->{
		System.out.println(user.getUsername());
		});

		//Iterating users list
//		users.forEach(item->System.out.println(item));
		System.out.println(users.stream().map(u->u.getUsername()+" test").reduce("",(c,u)->c+u));
		
//		users.stream().filter(user->user.getAddress().startsWith("Karve"));
		
		return users.stream()
				.filter(customer -> customer.getUsername().equals(name))
				.findFirst();
//		userN=users.stream().filter(s -> s.startsWi(name)).sorted().forEach(System.out::println);
		
	}

	@Override
	@Transactional
	@CacheEvict(value = "users", allEntries = true)
	public void saveUser(User user) {
//		user.setId(5);
		 Session sessionOne = sessionFactory.openSession();
	      sessionOne.beginTransaction();
	      sessionOne.save(user);
	      sessionOne.getTransaction().commit();
	      
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		 Session sessionOne = sessionFactory.openSession();
	      sessionOne.beginTransaction();
	      sessionOne.update(user);
	      sessionOne.getTransaction().commit();
		
	}

	
	@Override
	@Transactional
	public void deleteUserById(int id) {
		Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            
        }
        catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}


	

}
