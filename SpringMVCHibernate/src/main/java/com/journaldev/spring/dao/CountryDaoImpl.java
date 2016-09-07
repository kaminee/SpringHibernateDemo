package com.journaldev.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Country;

@Transactional 
@Component
public class CountryDaoImpl implements CountryDao {

	private SessionFactory sessionFactory;
	
	public CountryDaoImpl(){
		
	}
	public CountryDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	@Cacheable(value="country")
	public List<Country> fetchAllCountries() {
		
		System.out.println("\n\n\t =====sessionFactory==>"+sessionFactory);
		@SuppressWarnings("unchecked")
		List<Country> listCountries= sessionFactory.getCurrentSession()
				.createCriteria(Country.class)
				.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		System.out.println("\n\n\t =====listCountries==>"+listCountries.size());

		return listCountries;
	}
	
}
