package net.fanzhiwei.arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: zhiweifan
 * Date: 14-6-18
 * Time: 上午11:25
 * ThreeColorFlags问题最早由E.W.Dijkstra所提出，塔所使用的用语为Dutch Nation Flag（Dijkstra为荷兰人），
 * 而多数的作者则使用Three-Color Flag来说明。   
 * 假设有一条绳子，上面有红，白，蓝三种颜色的旗子，起初绳子上的旗子颜色并没有顺序，您希望将之分类，
 * 并排列蓝，白，红的顺序，要如何移动次数才会最少，注意您只能在绳子上进行这个动作，而且一次只能调换两个旗子。
 */
public class ThreeColorsFlags {
    private void swap(char[] flags, int x, int y) {
        char temp;
        temp = flags[x];
        flags[x] = flags[y];
        flags[y] = temp;
    }

    public String move(char[] flags) {
        int wFlag = 0;
        int bFlag = 0;
        int rFlag = flags.length - 1;
        while (wFlag <= rFlag) {
            if (flags[wFlag] == 'W') {
                wFlag++;
            } else if (flags[wFlag] == 'B') {
                swap(flags, bFlag, wFlag);
                bFlag++;
                wFlag++;
            } else {
                while (wFlag < rFlag && flags[rFlag] == 'R') rFlag--;
                swap(flags, rFlag, wFlag);
                rFlag--;
            }
        }
        return new String(flags);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("输入三色旗顺序（ex. RWBBWRWR）：");
        String flags = buf.readLine();
        ThreeColorsFlags threeColorsFlag = new ThreeColorsFlags();
        flags = threeColorsFlag.move(flags.toUpperCase().toCharArray());
        System.out.println("移动顺序后：" + flags);
    }
}