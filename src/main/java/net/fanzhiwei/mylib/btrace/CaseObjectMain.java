package net.fanzhiwei.mylib.btrace;

import java.util.Random;

/**
 * User: zhiweifan
 * Date: 14-5-30
 * Time: 下午4:07
 */
public class CaseObjectMain {

    public static void main(String[] args) throws Exception{
        Random random=new Random();
        CaseObject object=new CaseObject();
        while(true){
            boolean result=object.execute(random.nextInt(1000));
            Thread.sleep(1000);
        }
    }
}