package net.fanzhiwei.spring.scan.service.impl;

import net.fanzhiwei.spring.springframew0rk.context.Autowired;
import net.fanzhiwei.spring.springframew0rk.context.Service;

import net.fanzhiwei.spring.scan.dao.StudentDAO;
import net.fanzhiwei.spring.scan.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO sd;

    public StudentDAO getSd() {
        return sd;
    }

    @Autowired
    public void setSd(StudentDAO sd) {
        this.sd = sd;
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        sd.delete();
    }

    @Override
    public void save() {
        // TODO Auto-generated method stub
        sd.save();
    }

    @Override
    public void select() {
        // TODO Auto-generated method stub
        sd.select();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        sd.update();
    }

}
