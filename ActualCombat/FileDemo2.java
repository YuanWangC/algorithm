package ActualCombat;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/*
在文件a或目录下查找所有包含所求字符串的行
 */
public class FileDemo2 {
    static int m=1;
    //在文件a中的每行查找x
    static void search(File a, String x) throws IOException {
        Scanner scan = new Scanner(a,"gbk");
        int k = 0;
        while(scan.hasNext()){
            String s = scan.nextLine();
            k++;
            if(s.contains(x)){
                String ss ="gbk:"+ m+" File:"+a.getPath()+" the "+k+" line \n the content is "+s+"";
                System.out.println(ss);
                m++;
            }
        }
        Scanner scan1 = new Scanner(a,"utf-8");
        int k1 = 0;
        while(scan1.hasNext()){
            String s1 = scan1.nextLine();
            k1++;
            if(s1.contains(x)){
                String ss1 = "utf-8"+ m+" File:"+a.getPath()+" the "+k1+" line \n the content is "+s1+"";
                System.out.println(ss1);
                m++;
            }
        }
    }

    //在a下所有文件中查找含有s的行
    static void dfs(File a,String s) throws IOException {
        File[] ff = a.listFiles();
        if(ff == null)return;
        for(File f:ff){
            //如果f是文件，则进入查找
            if(f.isFile()){
                search(f,s);
            }
            //如果a是目录，则继续遍历
            if(f.isDirectory()){
                dfs(f,s);
            }
        }
    }
    public static void main(String[] args){
        try {
            dfs(new File("./ActualCombat"),"main(String[] args)");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
