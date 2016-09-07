package com.journaldev.spring.dao;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Group;

//@Transactional 
@Component
public class GroupDAOImpl implements GroupDAO {
	private static final AtomicInteger counter = new AtomicInteger();
//	private EntityManagerFactory
	private SessionFactory sessionFactory;
	public GroupDAOImpl(){
		
	}
	private static List<Group> groups;
	
	public GroupDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Group> list() {
		System.out.println("\n\t sessionFactory=============>"+sessionFactory);
		@SuppressWarnings("unchecked")
		List<Group> listUser = sessionFactory.getCurrentSession()
				.createCriteria(Group.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
			System.out.println("\n\t\t group====listUser==>"+listUser.size());
		return listUser;
	}

	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Group> findAllWithUsers(){
//	    Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Group.class);
		List<Group> listGrp= sessionFactory.getCurrentSession()
				.createCriteria(Group.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
//	    criteria.setFetchMode("users",org.hibernate.FetchMode.S);
	    //Other restrictions here as required.

	    return listGrp;
	}

	
	
	@Override
	@Transactional
	public Group findById(long id) {
		
		List<Group> groups = sessionFactory.getCurrentSession()
				.createCriteria(Group.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		System.out.println("\n\n\t ----users-------->"+groups.size());
		for(Group group : groups){
			if(group.getId() == id){
				return group;
			}
		}
		return null;
	}

	@Override
	public Group findByName(String name) {
		
		List<Group> groups = sessionFactory.getCurrentSession()
				.createCriteria(Group.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		
		for(Group group : groups){
			if(group.getName().equalsIgnoreCase(name)){
				return group;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void saveGroup(Group group) {
		 Session sessionOne = sessionFactory.openSession();
		 System.out.println("-------sessionFactory----------"+sessionFactory);
	      sessionOne.beginTransaction();
	      System.out.println("\n\n\t saving group --->"+group);
	      sessionOne.save(group);
	      sessionOne.getTransaction().commit();
	      
	}

	@Override
	@Transactional
	public void updateGroup(Group group) {
		 Session sessionOne = sessionFactory.openSession();
	      sessionOne.beginTransaction();
	      sessionOne.update(group);
	      sessionOne.getTransaction().commit();
		
	}

	
	@Override
	@Transactional
	public void deleteGroupById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Group group = (Group) session.get(Group.class, id);

            session.delete(group);
            session.getTransaction().commit();
            
        }
        catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

	}

	@Override
	public List<Group> findAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllGroups() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGroupExist(Group group) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
