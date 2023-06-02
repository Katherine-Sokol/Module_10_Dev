package com.goit.service;

import com.goit.database.HibernateUtil;
import com.goit.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService implements CrudService<Client>{
    HibernateUtil util;
    Session session;

    public ClientCrudService() {
        util = HibernateUtil.getInstance();
    }
    @Override
    public void create(Client client) {
        session = util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    @Override
    public Client getById(int id) {
        session = util.getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    @Override
    public List<Client> listAll() {
        session = util.getSessionFactory().openSession();
        List<Client> clientList = session.createQuery("from Client", Client.class).list();
        session .close();
        return clientList;
    }

    @Override
    public void deleteById(int id) {
        session = util.getSessionFactory().openSession();


    }
}
