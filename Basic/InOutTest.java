package Basic;
import java.util.Arrays;
import java.util.Scanner;
//输入包含空格的字符串，就需要使用nextLine
//输入字符串之前需要换行，用in.nextLine()
public class InOutTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        多组空格分割的两个整数 （无行数，结束字符限制）
        while(in.hasNextInt()){
            long a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a+b);
        }
//        第一行组数接空格分割的两个正整数 （行数限制）
//        int t = in.nextInt();
//        for(int i=0;i<t;i++){
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a+b);
//        }
//        空行分割的两个正整数，0 0 结束 （结束符限制）
//        while(in.hasNextInt()){
//            int a = in.nextInt();
//            int b = in.nextInt();
//            if(a==0 &&b==0)break;
//            System.out.println(a+b);
//        }
//        每行第一个为个数后带空格分割整数，0结束 （结束符限制,每行有个数限制）
//        while(in.hasNextInt()){
//            int num = in.nextInt();
//            if(num ==0)break;
//            int sum=0;
//            for(int i=0;i<num;i++){
//                sum+=in.nextInt();
//            }
//            System.out.println(sum);
//        }
//        第一行组数接第一个个数接空格分开的整数 （行数限制,每行有个数限制）
//        int num = in.nextInt();
//        for(int i=0;i<num;i++){
//            int t = in.nextInt();
//            int sum = 0;
//            for(int j=0;j<t;j++){
//                sum+=in.nextInt();
//            }
//            System.out.println(sum);
//        }
//        每行第一个为个数后带空格分割正整数 (无结束限制,每行有个数限制)
//        while(in.hasNext()){
//            int num = in.nextInt();
//            int sum=0;
//            for(int i=0;i<num;i++){
//                int n=in.nextInt();
//                if(n>0)sum+=n;
//                else break;
//            }
//            System.out.println(sum);
//        }
//        多组空格分隔的正整数 (无结束限制,每行无个数限制,需要当作字符串处理)
//        while(in.hasNextLine()){
//            String[] s = in.nextLine().split(" ");
//            int sum = 0;
//            for(String str:s){
//                sum +=Integer.parseInt(str);
//            }
//            System.out.println(sum);
//        }
//        第一行组数接空格分开的多个整数 (有行数限制,每行无个数限制,需要当作字符串处理)
//        int num =in.nextInt();
//        in.nextLine();  // 注意：读取行数后，要加一行in.nextLine();再读下面的行。
//        while(num>0){
//            String[] s = in.nextLine().split(" ");
//            int sum = 0;
//            for(String str:s)
//                sum+=Integer.parseInt(str);
//            System.out.println(sum);
//            num--;
//        }
//        第一行个数第二行字符串(1)
//        int num = in.nextInt();
//        String[] strs = new String[num];
//        for(int i=0;i<strs.length;i++){
//            strs[i] = in.next();
//        }
//        Arrays.sort(strs);
//        System.out.println(Arrays.toString(strs));
//                第一行个数第二行字符串(2)
//        int num = in.nextInt();
//        in.nextLine();
//        String[] s = in.nextLine().split(" ");
//        Arrays.sort(s);
//        for (int i = 0; i < s.length; i++) {
//            System.out.print(s[i] + " ");
//        }
//        多行空格分开的字符串
//        while(in.hasNextLine()){
//            String[] s = in.nextLine().split(" ");
//            Arrays.sort(s);
//            for(int i=0;i<s.length;i++)
//                System.out.print(s[i]+" ");
//            System.out.println();
//        }
//        多行逗号分开的字符串 （逗号和空格的区别就是最后一个字符输完的时候",“还是” " ）
//          while(in.hasNextLine()){
//              String[] s = in.nextLine().split(",");
//              Arrays.sort(s);
//              for(int i=0;i<s.length-1;i++)
//                  System.out.print(s[i]+",");
//              System.out.println(s[s.length-1]);
//          }
//        int类型二维数组输入，空格分开
//        int n = in.nextInt();
//        int[][] matrix = new int[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++)
//                matrix[i][j] = in.nextInt();
//        }
    }
}

