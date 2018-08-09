package com.mycompany.model.core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session()
	{
		return sessionFactory.getCurrentSession();
	}
	
}
