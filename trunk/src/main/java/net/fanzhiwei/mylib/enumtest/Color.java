package net.fanzhiwei.mylib.enumtest;

/**
 * User: zhiweifan
 * Date: 14-6-19
 * Time: 下午5:30
 */
//1.如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且 Java 要求必须先定义 enum 实例。
//2.所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类
interface Behaviour {
    void print();
    String getInfo();
}

public enum Color implements Behaviour{
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4); //必须先定义 ,必须有分号
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    //3.覆盖枚举的方法
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }


    @Override
    public void print() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getInfo() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
