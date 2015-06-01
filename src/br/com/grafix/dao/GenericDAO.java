package br.com.grafix.dao;

import br.com.grafix.model.AbstractModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generic DAO for CRUD operations
 * Created by Rogerio Ferracin on 29/05/2015.
 */
public abstract class GenericDAO<T> {

    private final static String UNIT_NAME = "GrafixPU";

    private Class<T> entityClass;

    @PersistenceContext(unitName = UNIT_NAME)
    private EntityManager em;

    public GenericDAO(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }

    /**
     * Save entity method
     * @param entity entity to be saved
     */
    public void save(T entity) {
        em.persist(entity);
    }

    /**
     * Update entity method
     * @param entity entity to be updated
     * @return Updated entity
     */
    public T update(T entity){
        return em.merge(entity);
    }

    /**
     * Delete entity method
     * @param id Id from entity
     * @param entityClass Class from entity
     */
    protected void delete(Object id, Class<T> entityClass){
        T entityToBeRemoved = em.getReference(entityClass, id);
        em.remove(entityToBeRemoved);
    }

    /**
     * Find entity by its ID
     * @param entityId Id from entity
     * @return Entity from BD
     */
    public T findById(int entityId){
        return em.find(entityClass, entityId);
    }

    /**
     * Get all results from BD
     * @return List of entities
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll(){
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

}
