package net.fanzhiwei.mylib.btrace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * User: zhiweifan
 * Date: 14-5-30
 * Time: 下午5:35
 */
public class Main

{

    public static void main(String[] args) throws Exception

    {

        Main test = new Main();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++)

        {

            reader.readLine();

            int a = (int) Math.round(Math.random() * 1000);

            int b = (int) Math.round(Math.random() * 1000);

            System.out.println(test.add(a, b));

        }

    }

    public int add(int a, int b)

    {

        return a + b;

    }

}
