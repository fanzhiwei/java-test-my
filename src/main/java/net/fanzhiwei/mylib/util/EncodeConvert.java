package net.fanzhiwei.mylib.util;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * User: zhiweifan
 * Date: 14-6-17
 * Time: 下午4:30
 */
public class EncodeConvert {
    private static void transferFile(String srcFileName, String destFileName) throws IOException {
        String line_separator = System.getProperty("line.separator");
        FileInputStream fis = new FileInputStream(srcFileName);
        StringBuffer content = new StringBuffer();
        DataInputStream in = new DataInputStream(fis);
        BufferedReader d = new BufferedReader(new InputStreamReader(in, "GBK"));// , "UTF-8"
        String line = null;
        while ((line = d.readLine()) != null)
            content.append(line + line_separator);
        d.close();
        in.close();
        fis.close();

        Writer ow = new OutputStreamWriter(new FileOutputStream(destFileName), "utf-8");
        ow.write(content.toString());
        ow.close();
    }

    private static void transerFileRecu(File dir) {
        File[] fs = dir.listFiles();
        for(int i=0; i<fs.length; i++){
            System.out.println(fs[i].getAbsolutePath());
            if(fs[i].isDirectory()){
                try{
                    transerFileRecu(fs[i]);
                }catch(Exception e){
                    System.out.println("递归调用失败");
                }
            } else {
                try{
                    transferFile(fs[i].getAbsolutePath(),fs[i].getAbsolutePath().split(".java")[0] + ".java");
                }catch(Exception e){
                    System.out.println("转换utf8失败");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        transferFile("E:\\IntelliJIDEAWorkSpace\\java_test\\src\\main\\java\\net\\fanzhiwei\\mylib\\util\\Autowired.java","E:\\IntelliJIDEAWorkSpace\\java_test\\src\\main\\java\\net\\fanzhiwei\\mylib\\util\\Autowired1.java");
         File f = new File("E:\\temp\\temp1");
         transerFileRecu(f);
    }

    private static void showAllFiles(File dir) throws Exception{
        File[] fs = dir.listFiles();
        for(int i=0; i<fs.length; i++){
            System.out.println(fs[i].getAbsolutePath());
            if(fs[i].isDirectory()){
                try{
                    showAllFiles(fs[i]);
                }catch(Exception e){

                }
            }
        }
    }
}
