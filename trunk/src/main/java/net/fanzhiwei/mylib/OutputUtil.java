package net.fanzhiwei.mylib;

/**
 * User: zhiweifan
 * Date: 14-5-22
 * Time: 下午5:17
 */
public class OutputUtil {
    public static void out(String message,Object obj) {
        if (obj == null) {
            System.out.println(message + ":输出对象为null");
        } else {
            System.out.println(message + ":" + obj.toString());
        }

    }
}
