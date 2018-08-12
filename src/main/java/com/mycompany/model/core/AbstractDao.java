package com.mycompany.model.core;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractDao<T>
{
    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> persistentClass;
    
    public AbstractDao()
    {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];  
    }

    public EntityManager entityManager()
	{
    	return entityManager;
	}
    
    public T save(T entity)
    {
    	return entityManager.merge(entity);
    }
    
    public T getById(Integer id)
    {
    	return entityManager.find(persistentClass, id);
    }
    
}
