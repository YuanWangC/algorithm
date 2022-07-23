package ActualCombat;

public class StringTableTest {
    //执行之前，只是常量池中的符号，并没有加载到内存（懒加载）
    public void m1(){
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1+s2;	//StringBuilder.append().append().toString() 返回了新的对象
        System.out.println(s3 == s4);  //false
    }
    public static void main(String[] args){
        StringTableTest obj = new StringTableTest();
        obj.m1();
    }
}
