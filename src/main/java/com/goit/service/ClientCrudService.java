package com.goit.service;

import com.goit.database.HibernateUtil;
import com.goit.entity.Client;
import com.goit.exception.CrudServiceException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService implements CrudService<Client> {
    @Override
    public void create(Client client) {
        if (client == null) {
            throw new CrudServiceException("Attempt to create client with null");
        }
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        }
    }

    @Override
    public Client getById(int id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    @Override
    public Client getById(String id) {
        return null;
    }

    @Override
    public List<Client> listAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Client", Client.class).list();
        }
    }

    @Override
    public void update(Client client) {
        if (client == null) {
            throw new CrudServiceException("Attempt to update client with null");
        }
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(client);
            transaction.commit();
        }
    }

    @Override
    public void delete(Client client) {
        if (client == null) {
            throw new CrudServiceException("Attempt to delete client with null");
        }
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
        }
    }
}
