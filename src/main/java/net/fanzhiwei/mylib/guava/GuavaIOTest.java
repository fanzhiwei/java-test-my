package net.fanzhiwei.mylib.guava;


import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import static net.fanzhiwei.mylib.OutputUtil.out;

/**
 * User: zhiweifan
 * Date: 14-5-21
 * Time: 下午4:53
 */
public class GuavaIOTest {

    //读取文件ByGuava
    @Test
    public void readFileByGuava() {
        File file = new File(getClass().getResource("/readLineTest.txt").getFile());
        List<String> lines = null;
        try {
            lines = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }

    //读取文件ByJDK
    @Test
    public void readFileByJDK() {
        File file = new File(getClass().getResource("/readLineTest.txt").getFile());
        BufferedReader reader;
        String text = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                text += line.trim() + "\n";
            }
            reader.close();
            reader = null;
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
