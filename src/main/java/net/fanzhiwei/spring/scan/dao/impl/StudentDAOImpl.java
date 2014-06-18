package net.fanzhiwei.spring.scan.dao.impl;

import net.fanzhiwei.spring.springframew0rk.context.Repository;

import net.fanzhiwei.spring.scan.dao.StudentDAO;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        System.out.println("dao delete");
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        System.out.println("dao save");
    }

    @Override
    public void select() {
        // TODO Auto-generated method stub
        System.out.println("dao select");
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        System.out.println("dao update");
    }

}
