import java.util.HashSet;
import java.util.Objects;

public class EqualsTest {
    public static void main(String[] args){
        eTest obj1 = new eTest("a");
        eTest obj2 = new eTest("a");
        System.out.println(obj2.equals(obj1));
        System.out.println(obj1 == obj2);
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        HashSet<eTest> set = new HashSet<>();
        set.add(obj1);
        set.add(obj2);
        System.out.println(set.size());
    }
}
class eTest{
    private String name = "";
    public eTest(){}
    public eTest(String s){
        this.name = s;
    }
    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o==null || getClass() !=o.getClass())return false;
        eTest o1 = (eTest) o;
        return Objects.equals(this.name,o1.name);
    }
    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}