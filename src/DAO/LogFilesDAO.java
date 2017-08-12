/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import logfiles.LogFiles;

/**
 *
 * @author gezu-pc
 */
public interface LogFilesDAO {

    public void create(LogFiles logFiles);

    public void delete(LogFiles logFiles);

    public void update(LogFiles logFiles);

    public LogFiles retrieve(String logname);

    public boolean exists(String logname);

    public Long numberOfLogFiles();
}
