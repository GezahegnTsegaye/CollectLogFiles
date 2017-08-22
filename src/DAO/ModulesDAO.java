/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Modules;

/**
 *
 * @author gezu-pc
 */
public interface ModulesDAO {

    public void create(Modules modules);

    public void delete(Modules modules);

    public void update(Modules modules);

    public Modules retrieve(String name);
    
    public boolean exists(String name);
    
    public Long numberOfLogFiles();
}
