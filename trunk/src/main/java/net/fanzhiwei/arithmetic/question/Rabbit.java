//【程序1】 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
//假如兔子都不死，问每个月的兔子总数为多少？ 1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21.... 
package net.fanzhiwei.arithmetic.question;

public class Rabbit
{
    public static final int MONTH = 15;

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int a = 1, b = 1, c;
        for (int i = 1; i <= 12; i++)
        {
            if (i <= 2)
            {
                System.out.println("第" + i + "个月的兔子数：1");
            }
            else
            {
                c = a + b;
                System.out.println("第" + i + "个月的兔子数：" + c);
                a = b;
                b = c;
            }
        }
    }
}
// 算法设计：用a，b分别表示每月前2个月和前1个月的兔子对数，第1和第2个月的兔子数作为初值都为1，第3个月的兔子数为c=a+b。
// 求第4个月的兔子数时，将第4个月的前2个月和前1个月的兔子对数分别存储在a，b中，即a=b,b=c，构造循环不变式。

//我的分析，任意月份，有三种状态的兔子对数，加起来即为总数。
