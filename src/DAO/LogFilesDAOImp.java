/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import logfiles.HandleDB;
import logfiles.LogFiles;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author gezu-pc
 */
public class LogFilesDAOImp implements LogFilesDAO {

    private HandleDB handleDB;

    public HandleDB getHandleDB() {
        return handleDB;
    }

    public void setDbHandler(HandleDB handleDB) {
        this.handleDB = handleDB;
    }

    public LogFilesDAOImp() {
    }

    @Override
    public void create(LogFiles logFiles) {
        handleDB.create(logFiles);
    }

    @Override
    public void delete(LogFiles logFiles) {
        handleDB.delete(logFiles);
    }

    @Override
    public void update(LogFiles logFiles) {
        handleDB.update(logFiles);
    }

    @Override
    public LogFiles retrieve(String logname) {
        String queryString = "from LogFiles where logname = :logFiles";
        Query query = handleDB.getSession().createQuery(queryString);
        query.setParameter("logFiles", logname);
        LogFiles u = (LogFiles) query.uniqueResult();
//        handleDB.close();
        return u;
    }

    @Override
    public boolean exists(String logname) {
        return retrieve(logname) != null;
    }

    @Override
    public Long numberOfLogFiles() {
        Long size = (Long) handleDB.getSession().createQuery("select count(*) from LogFiles").uniqueResult();
        return size;
    }

    public static void main(String args[]) {
        LogFilesDAOImp imp = new LogFilesDAOImp();
        LogFiles logFiles = new LogFiles();
        logFiles.setLogName("information");
        String names = logFiles.getLogName();

//        System.out.println("imp = " + imp.retrieve(names));
    }
}
