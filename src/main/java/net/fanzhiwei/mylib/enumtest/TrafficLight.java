package net.fanzhiwei.mylib.enumtest;

/**
 * User: zhiweifan
 * Date: 14-6-19
 * Time: 下午5:24
 */
enum Signal {
    GREEN, YELLOW, RED
}
public class TrafficLight {
    Signal color = Signal.RED;
    public void change() {
//        switch语句只支持int,char,enum类型
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
        }
    }

    public static void main(String[] args) {
        TrafficLight tl = new TrafficLight();
        tl.change();
        System.out.println(tl.color.toString());
    }
}