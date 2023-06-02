package com.goit.service;

import com.goit.database.HibernateUtil;
import com.goit.entity.Client;
import com.goit.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService implements CrudService<Planet>{
    HibernateUtil util;
    Session session;

    public PlanetCrudService() {
        util = HibernateUtil.getInstance();
    }
    @Override
    public void create(Planet planet) {
        session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    @Override
    public Planet getById(int id) {
        session = util.getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    @Override
    public List<Planet> listAll() {
        session = util.getSessionFactory().openSession();
        List<Planet> planetList = session.createQuery("from Planet", Planet.class).list();
        session .close();
        return planetList;
    }

    @Override
    public void deleteById(int id) {

    }
}
