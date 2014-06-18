package net.fanzhiwei.spring.springframework.context;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private String xml;
    private static Map<String, Object> map;//Map<bean的id，Object是class产生的对象>

    public ClassPathXmlApplicationContext(String xml) {

        this.xml = xml;
        try {
            map = this.parseXml(xml);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Map parseXml(String xml) throws DocumentException, ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Map<String, Object> m = new HashMap<String, Object>();

        File file = new File("src/" + xml);
        SAXReader sax = new SAXReader();
        Document doc = sax.read(file);
        //得到根目录<beans>
        Element root = doc.getRootElement();
        //得到所有的二级节点<bean>
        List beans = root.elements();

        for (Object obj : beans) {

            Element ele = (Element) obj;
            //得到bean标签的class属性
            String clazz = ele.attributeValue("class");

            String id = ele.attributeValue("id");
            //根椐class属性产生对象
            Class c = Class.forName(clazz);
            Object o = c.newInstance();
            //判断bean标签下面有没有property
            Element property = ele.element("property");
            if (property != null) {
                //得到property的两个属性
                String name = property.attributeValue("name");
                String ref = property.attributeValue("ref");
                //根椐ref属性找到对应的对象有在map中
                Object in = m.get(ref);

                //生成要注入的属性的setter方法
                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);

                //在bean的对象在找到setter方法的对象
                Method me = o.getClass().getMethod(methodName, new Class[]{in.getClass().getInterfaces()[0]});
                //执行bean对象的setter方法，将对象进入注入
                me.invoke(o, new Object[]{in});

            }
            //将bean的对象加入到m中待用
            m.put(ele.attributeValue("id"), o);

        }
        return m;
    }

    public Object getBean(String id) {

        return map.get(id);

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
