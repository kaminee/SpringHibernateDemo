package com.journaldev.spring.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Group;
import com.journaldev.spring.model.User;


//@Transactional 
@SuppressWarnings("unchecked")
@Component
public class GroupDAOImpl implements GroupDAO {
	private SessionFactory sessionFactory;
	private static final Logger logger =LoggerFactory.getLogger(GroupDAOImpl.class);

	public GroupDAOImpl() {

	}

//	private static List<Group> groups;

	public GroupDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Group> list() {
		logger.info("\n\t sessionFactory=============>" + sessionFactory);
		List<Group> listUser = sessionFactory.getCurrentSession().createCriteria(Group.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		logger.info("\n\t\t group====listUser==>" + listUser.size());
		return listUser;
	}

	@Override
	@Transactional
	public List<Group> findAllWithUsers() {
		List<Group> listGrp = sessionFactory.getCurrentSession().createCriteria(Group.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		return listGrp;
	}

	@Override
	@Transactional
	public Group findById(long id) {

		List<Group> groups = sessionFactory.getCurrentSession().createCriteria(Group.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		for (Group group : groups) {
			if (group.getId() == id) {
				return group;
			}
		}
		return null;
	}

	@Override
	public Group findByName(String name) {

	
		List<Group> groups = sessionFactory.getCurrentSession().createCriteria(Group.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();

		for (Group group : groups) {
			if (group.getName().equalsIgnoreCase(name)) {
				return group;
			}
		}
		return null;
	}

	@Override
	@Transactional
	public void saveGroup(Group group,int userId) {
		try {
			Session sessionOne = sessionFactory.openSession();
			sessionOne.beginTransaction();
			User existingUser = (User) sessionOne.get(User.class, userId);
//			existingUser.getGroups().add(group);
			group.getUsers().add(existingUser);
			sessionOne.save(group);
			sessionOne.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	@Transactional
	public void updateGroup(Group group) {
		Session sessionOne = sessionFactory.openSession();

		try {
		sessionOne.beginTransaction();
		
		sessionOne.update(group);
		sessionOne.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
//			sessionOne.getTransaction().rollback();
		}
	}

	@Override
	@Transactional
	public void deleteGroupById(int id) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			Group group = (Group) session.get(Group.class, id);

			session.delete(group);
			session.getTransaction().commit();

		} catch (HibernateException e) {
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
