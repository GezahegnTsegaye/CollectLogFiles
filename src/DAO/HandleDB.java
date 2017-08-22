/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author gezu-pc
 */
public class HandleDB {

    private SessionFactory sessionFactory;
    private Transaction tx;
    private Session session;

    private static enum Operation {
        CREATE, UPDATE, DELETE
    };

    public HandleDB() {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory(builder.build());
    }

    private void performOperation(Object obj, Operation op) {

        try {
            begin();
            switch (op) {
                case CREATE:
                    getSession().saveOrUpdate(obj);
                    break;
                case UPDATE:
                    getSession().update(obj);
                    break;
                case DELETE:
                    getSession().delete(obj);
                    break;
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            close();
        }
    }

    public void create(Object obj) {
        performOperation(obj, Operation.CREATE);
    }

    public void delete(Object obj) {
        performOperation(obj, Operation.DELETE);
    }

    public void update(Object obj) {
        performOperation(obj, Operation.UPDATE);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        session = sessionFactory.openSession();
        return session;
    }

    public void begin() {
        tx = session.beginTransaction();
    }

    public void close() {
        session.close();
    }

}
