package net.fanzhiwei.mylib.enumtest;
/**
 * User: zhiweifan
 * Date: 14-6-19
 * Time: 下午5:33
 */
public class Test {
    @org.junit.Test
    public void test() {
        Color c = Color.RED;
        System.out.println(c.getName(2));
        System.out.println(c.getName());
        System.out.println(c.getIndex());
        //重写的toString以后，输出重写结果，未重写时，输出枚举变量名RED
        System.out.println(c);
    }
}
