package ActualCombat;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

//加载字节码
public class MethodAreaOOMTest extends ClassLoader {
    public static void main(String[] args){
        int j = 0;
        try{
            MethodAreaOOMTest obj = new MethodAreaOOMTest();
            for(int i=0;i<10000;i++,j++){
                //ClassWriter用于生成二进制字节码文件
                ClassWriter cw = new ClassWriter(0);
                //用visit方法创建一个类，版本号，修饰符，类名，包名，父类，实现接口
                cw.visit(Opcodes.V11,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
                //保存字节码文件到byte数组中
                byte[] code = cw.toByteArray();
                //触发类的加载（类名，读取的byte数组，start，end），无后续链接等步骤,返回类对象
                obj.defineClass("Class"+i,code,0,code.length);
            }
        }finally {
            System.out.println(j);
        }
    }
}
