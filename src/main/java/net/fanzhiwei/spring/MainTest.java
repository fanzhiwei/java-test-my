package net.fanzhiwei.spring;

import net.fanzhiwei.spring.springframework.context.AnnotationXmlApplicationContext;
import net.fanzhiwei.spring.springframework.context.ApplicationContext;

import net.fanzhiwei.spring.scan.action.StudentAction;

/**
 * spring原理
 */
public class MainTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ApplicationContext context
                //	          = new ClassPathXmlApplicationContext("net/fanzhiwei/spring/spring.xml");

                = new AnnotationXmlApplicationContext("net/fanzhiwei/spring/spring_annotation.xml");
        StudentAction sa = (StudentAction) context.getBean("studentAction");
        sa.save();
    }
}
