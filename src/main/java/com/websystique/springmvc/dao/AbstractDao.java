package com.websystique.springmvc.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by User on 21.03.2017.
 */
public abstract class AbstractDao<PK extends Serializable, T>  {

    private final Class<T> persistantClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistantClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistantClass, key);
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void update (T entity) {
        getSession().update(entity);
    }

    public void delete (T entity) {
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistantClass);
    }
}
