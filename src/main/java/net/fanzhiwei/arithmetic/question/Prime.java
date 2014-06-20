//【程序2】题目：判断101-200之间有多少个素数，并输出所有素数。 1.程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数
package net.fanzhiwei.arithmetic.question;

public class Prime
{
    public static int countPrime(int start, int end)
    {
        int count = 0;
        for (int i = start; i <= end; i++)
        {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++)
            {
                if (i % j == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
            {
                count++;
                System.out.print(i + " ");
            }
        }
        return count;

    }

    public static void main(String[] args)
    {
        int count = countPrime(101, 200);
        System.out.println("\n素数的个数" + count);
    }
}
