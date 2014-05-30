package net.fanzhiwei.mylib.introspector;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User: zhiweifan
 * Date: 14-5-30
 * Time: 上午10:57
 */
public class UserBeanHandlerOne {

    public static void main(String args[]) {
        UserBean user = new UserBean();
        try {
            handleBean(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleBean(UserBean user)
            throws IntrospectionException, IllegalArgumentException,
            IllegalAccessException, InvocationTargetException {
        BeanInfo bi = Introspector.getBeanInfo(user.getClass());
        PropertyDescriptor[] pd = bi.getPropertyDescriptors();
        for (PropertyDescriptor p : pd) {
            String attrName=p.getName();
            if(attrName.equals("name")||attrName.equals("age")){
                Method writeMethod=p.getWriteMethod();//得到set方法
                Class clazz[]=writeMethod.getParameterTypes();
                if(clazz[0]==int.class)
                    writeMethod.invoke(user, 20);
                else
                    writeMethod.invoke(user, "peter");//执行set方法
                Method readMethod = p.getReadMethod();//获取get方法
                Object obj = readMethod.invoke(user);//执行get方法
                System.out.println(obj);
            }
        }

        //获取单个属性
        UserBean ub=new UserBean();
        PropertyDescriptor p=new PropertyDescriptor("name",UserBean.class);
        Method writeMethod=p.getWriteMethod();
        writeMethod.invoke(ub,"peter");
        Method readMethod=p.getReadMethod();
        Object str=readMethod.invoke(ub);
        System.out.println(str);
    }
}

