package Basic;

public class InheritanceTest {
    public static void main(String[] args){
        Animals a1 = new Animals("Sally",1);
        Animals a2 = new Animals("Tommy",5,a1);
        System.out.println(a2 instanceof Animals);
        System.out.println(a2.name+" has a child named "+a2.child.name);
        Dog d1 = new Dog("lily");
        Dog d2 = new Dog("Jerry",5,d1);
        System.out.println(d2 instanceof Animals);
        System.out.println(d2 instanceof Dog);
        System.out.println(d2.name+" has a child named "+d2.child.name);
        d2.child = new Animals("newborn");  //父类实例无法强制转换为子类
        //d2.child = new Dog("newborn");
        System.out.println(d2.child instanceof Dog);
        System.out.println("there is a new born named "+d2.child.name);

        //转换失败
//        Animals animal1 = new Animals();
//		Dog dog = (Dog)animal1;

        //转换成功
        Animals animal2 = new Dog();
        Dog dog2 = (Dog) animal2;
        System.out.println(dog2.name);  //默认调用父类成员变量
        dog2.eat();     //子类重写方法调用
        dog2.play();    //父类未重写方法调用
    }
}
class Animals{
    int age = 0;
    String name = "animal name";
    Animals child = null;
    public Animals(){}
    public Animals(String name){
        this.name = name;
    }
    public Animals(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Animals(String name,int age,Animals child){
        this.name = name;
        this.age = age;
        this.child = child;
    }
    public void eat() {
        System.out.println("an animal is eating...");
    }
    public void play() {
        System.out.println("an animal is playing...");
    }
}
class Dog extends Animals{
    public Dog(){}
    public Dog(String name){
        super(name);
    }
    public Dog(String name,int age,Animals child){
        super(name,age,child);
    }
    public void eat() {
        System.out.println(this.name + "正在吃饭");
    }
}