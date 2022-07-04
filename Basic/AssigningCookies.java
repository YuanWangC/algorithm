package Basic;

import java.util.Arrays;
import java.util.Scanner;

public class AssigningCookies {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0)return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        for(int i=0;i<s.length;i++){
            if(s[i]>=g[child])child++;
            if(child>=g.length)break;
        }
        return child;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] students = in.nextLine().split(",");
        String[] cookies = in.nextLine().split(",");
        int[] stu = new int[students.length];
        int[] coo = new int[cookies.length];
        for(int i=0;i<students.length;i++)
            stu[i] = Integer.parseInt(students[i]);
        for(int i=0;i<cookies.length;i++)
            coo[i] = Integer.parseInt(cookies[i]);
        AssigningCookies obj = new AssigningCookies();
        int res = obj.findContentChildren(stu,coo);
        System.out.println(res);
    }
}
