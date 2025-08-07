package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.dataaccess.IGenericDal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class GenericRepository<T> implements IGenericDal<T> {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("yourPersistenceUnit"); // persistence.xml'deki ad

    private Class<T> entityClass;

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void insert(T t) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(T t) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(T t) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            T managed = em.merge(t); // Detached objeyi manage hale getir
            em.remove(managed);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> getList() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
        } finally {
            em.close();
        }
    }
}
