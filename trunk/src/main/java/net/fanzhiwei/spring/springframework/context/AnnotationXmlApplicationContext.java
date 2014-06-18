package net.fanzhiwei.spring.springframework.context;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.fanzhiwei.spring.springframew0rk.context.Autowired;
import net.fanzhiwei.spring.springframew0rk.context.Controller;
import net.fanzhiwei.spring.springframew0rk.context.Repository;
import net.fanzhiwei.spring.springframew0rk.context.Service;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class AnnotationXmlApplicationContext implements ApplicationContext {

    private Map<String, Object> map0 = new HashMap<String, Object>(); // 存放(id,class产生的对象)

    public AnnotationXmlApplicationContext(String xml) {

        try {
            this.parse(xml);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void parse(String xml) throws Exception {
        // TODO Auto-generated method stub

        SAXReader sx = new SAXReader();
        Document doc = sx.read(new File(this.getClass().getResource("/").getPath() + xml));
        Element ele = doc.getRootElement();
        Element com = ele.element("component-scan");
        String packname = com.attributeValue("base-package");

        String realpackname = packname.replaceAll("\\.", "/");

        File file = new File(this.getClass().getResource("/").getPath() + realpackname);
        componentscan(file.listFiles());// 扫描所有的类
        discan(map0);

    }

    // 扫描所有类后，对其方法进入注入
    private void discan(Map<String, Object> map02)
            throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        // TODO Auto-generated method stub
        for (Object obj : map02.values()) { // 得到map中的所有值

            Class c = obj.getClass();
            // 查找方法，哪个方法有@Autowired
            Method[] ms = c.getMethods();
            for (Method m : ms) {
                // setSS(StudentService ss);
                if (m.getAnnotation(Autowired.class) != null) {

                    // 找到要注入的方法后，再找到方法中要注入的类型
                    Class cc = m.getParameterTypes()[0];
                    System.out.println(cc);
                    // 在map中找到和这个类型匹配的进行注入
                    for (Object o : map02.values()) {
                        Class clazz[] = o.getClass().getInterfaces();
                        if (clazz.length != 0) {
                            if (cc == clazz[0]) {// 因为方法中的参数是接口，所以我们要找到注入对象的接口相匹配的
                                m.invoke(obj, new Object[]{o});
                            }
                        }
                    }
                }
            }
        }
    }

    // 扫描所有的组件,即扫描所有指定包下面的类
    private void componentscan(File[] files) throws Exception {
        // TODO Auto-generated method stub
        for (File file : files) {

            if (file.isFile()) {
                String filePath = file.getPath();
                // 得到类的全路径
                String path = filePath.split("classes\\\\")[1].split("\\.class")[0].replaceAll("\\\\","\\.");

                Class c = Class.forName(path);
                if (c.getAnnotation(Service.class) != null
                        || c.getAnnotation(Controller.class) != null
                        || c.getAnnotation(Repository.class) != null) {
                    Object obj = c.newInstance(); // 产生一个实例 ，加入到map中
                    String id = c.getSimpleName().substring(0, 1).toLowerCase()
                            + c.getSimpleName().substring(1);
                    map0.put(id, obj);
                }
            } else {
                componentscan(file.listFiles());
            }
        }
    }

    @Override
    public Object getBean(String id) {
        // TODO Auto-generated method stub
        return map0.get(id);
    }

    public static void main(String[] args) {
        new AnnotationXmlApplicationContext("net/fanzhiwei/spring/spring_annotation.xml");
    }
}
