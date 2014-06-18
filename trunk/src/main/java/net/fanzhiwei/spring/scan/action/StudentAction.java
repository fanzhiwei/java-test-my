package net.fanzhiwei.spring.scan.action;

import net.fanzhiwei.spring.springframew0rk.context.Autowired;
import net.fanzhiwei.spring.springframew0rk.context.Controller;

import net.fanzhiwei.spring.scan.service.StudentService;

@Controller
public class StudentAction {

    private StudentService ss;

    public StudentService getSs() {
        return ss;
    }

    @Autowired
    public void setSs(StudentService ss) {
        this.ss = ss;
    }

    public String save() {

        ss.save();
        return "save";
    }

    public String delete() {
        ss.delete();
        return "delete";
    }
}
