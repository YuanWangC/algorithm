package ActualCombat;

public class VMStackOOMTest {
    private static int count = 0;
    public static void method(){
        count++;
        method();
    }
    public static void main(String[] args){
        try {
            VMStackOOMTest.method();
        }catch (Throwable e) {
            e.printStackTrace();
            System.out.println(VMStackOOMTest.count);
        }
    }
}
