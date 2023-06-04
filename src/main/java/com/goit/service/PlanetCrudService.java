package com.goit.service;

import com.goit.database.HibernateUtil;
import com.goit.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService implements CrudService<Planet> {

    @Override
    public void create(Planet planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        }
    }

    @Override
    public Planet getById(int id) {
        return null;
    }

    @Override
    public Planet getById(String id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    @Override
    public List<Planet> listAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Planet", Planet.class).list();
        }
    }

    @Override
    public void update(Planet planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(planet);
            transaction.commit();
        }
    }

    @Override
    public void delete(Planet planet) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
        }

    }
}
