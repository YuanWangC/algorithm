package ActualCombat;

public class StringTableTest {
    //执行之前，只是常量池中的符号，并没有加载到内存（懒加载）
    public void m1(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1+s2;	//StringBuilder.append().append().toString() 返回了新的对象
        System.out.println(s3 == s4);  //false
        String s5 = "a"+"b";
        System.out.println(s3 == s5);

//        String x = "cd";  //在串池中放入"cd"对象
        //用new创建了"c","d","cd"三个对象，串池中存储了"c","d",但是没有”cd“
        String s6 = new String("c")+new String("d");

        //此处尝试堆中对象入池，并返回串池中的对象;如果s6入池成功，s7和s6指向相同对象；如果串池中已经存在，则入池失败，直接返回串池中的对象
        String s7 = s6.intern();
        System.out.println(s6.equals(s7)); //String类型变量的value相同，则equals结果相同
//        System.out.println(s7 == x);
//        System.out.println(s6 == x);    //串池中已存在，则为false
        System.out.println(s7 == "cd");
        System.out.println(s6 == "cd");    //串池中本来不存在，则为true
    }
    public static void main(String[] args){
        StringTableTest obj = new StringTableTest();
        obj.m1();
    }
}
