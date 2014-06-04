package net.fanzhiwei.mylib.btrace;

/**
 * User: zhiweifan
 * Date: 14-5-30
 * Time: 下午4:05
 */
public class CaseObject {

    private static int sleepTotalTime = 0;

    public boolean execute(int sleepTime) throws Exception {
        System.out.println("sleep: " + sleepTime);
        sleepTotalTime += sleepTime;
        Thread.sleep(sleepTime);
        if (sleepTime % 2 == 0)
            return true;
        else
            return false;
    }

}
