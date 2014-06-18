package net.fanzhiwei.mylib.regrex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static net.fanzhiwei.mylib.OutputUtil.out;

/**
 * User: zhiweifan
 * Date: 14-6-13
 * Time: 下午5:14
 */
public class SimplePattern {
    @Test
    public void test() {
        //Java中在某个字符串中查询某个字符或者某个子字串
        String s = "@Shang Hai Hong Qiao Fei Ji Chang";
        String regEx = "a|F"; //表示a或F
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        boolean rs = mat.find();
        out("是否找到了包含子串",rs);
        for(int i=1;i<=mat.groupCount();i++){
            System.out.println(mat.group(i));
        }
    }
}
