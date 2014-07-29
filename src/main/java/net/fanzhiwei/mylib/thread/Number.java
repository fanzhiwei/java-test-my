package net.fanzhiwei.mylib.thread;

/**
 * User: zhiweifan
 * Date: 14-7-10
 * Time: 下午4:51
 */
public class Number implements Runnable{

    private Integer count=1; //不可变对象

    @Override
    public void run() {
        while(true){
            synchronized (count) {  //同步锁定不同的对象
                if(count>30){
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count+"-----------");
                count++;  //生成新对象，但引用未变
                System.out.println(count);
            }
        }
    }

    public static void main(String[] args) {
        Number n = new Number();

        Thread t1=  new Thread(n,"Number1");
        Thread t2=  new Thread(n,"Number2");
        Thread t3=  new Thread(n,"Number3");

        t1.start();
        t2.start();
        t3.start();
    }
}