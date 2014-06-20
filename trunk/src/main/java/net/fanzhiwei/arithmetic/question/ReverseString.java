package net.fanzhiwei.arithmetic.question;

public class ReverseString
{
    public static String reverseString(String oldStr)
    {
        if (oldStr.length() == 0){
            return "";
        }
        else {
            String subProblem = oldStr.substring(1);
            return reverseString(subProblem) + oldStr.substring(0, 1);
        }
    }
    
    public static void main(String[] args){
        String str = "abcdefg";
        System.out.println(reverseString(str));
    }
}
