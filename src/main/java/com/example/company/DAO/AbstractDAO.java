package com.example.company.DAO;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Magda on 20.05.2018.
 */
@Transactional
public class AbstractDAO<T extends Serializable>  {

    private Class<T> clazz;

    @PersistenceContext
    EntityManager entityManager;

    public final void setClass(Class<T> classToSet) {
        this.clazz = classToSet;
    }

    public List findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public void create(T entity) throws DuplicateKeyException {
        try {
            entityManager.persist(entity);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateKeyException("Entity exists");
        }
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }




}
