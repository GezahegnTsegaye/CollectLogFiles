/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Modules;
import org.hibernate.Query;

/**
 *
 * @author gezu-pc
 */
public class ModulesDAOImp implements ModulesDAO{
    private HandleDB handleDB;

    public HandleDB getHandleDB() {
        return handleDB;
    }

    public void setDbHandler(HandleDB handleDB) {
        this.handleDB = handleDB;
    }

    public ModulesDAOImp() {
    }

    @Override
    public void create(Modules modules) {
        handleDB.create(modules);
    }

    @Override
    public void delete(Modules modules) {
        handleDB.delete(modules);
    }

    @Override
    public void update(Modules modules) {
        handleDB.update(modules);
    }

    @Override
    public Modules retrieve(String name) {
        String queryString = "from Modules where name = :name";
        Query query = handleDB.getSession().createQuery(queryString);
        query.setParameter("name", name);
        Modules u = (Modules) query.uniqueResult();
//        handleDB.close();
        return u;
    }

    @Override
    public boolean exists(String name) {
        return retrieve(name) != null;
    }

    @Override
    public Long numberOfLogFiles() {
        Long size = (Long) handleDB.getSession().createQuery("select count(*) from Modules").uniqueResult();
        return size;
    }

    public static void main(String args[]) {
        LogFilesDAOImp imp = new LogFilesDAOImp();
        Modules modules = new Modules();
        modules.setName("information");
        String names = modules.getName();

//        System.out.println("imp = " + imp.retrieve(names));
    }
}
