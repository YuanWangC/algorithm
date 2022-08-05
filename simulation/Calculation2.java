import java.util.ArrayDeque;
/*
只有加减乘除取余计算器
 */
public class Calculation2 {
    public int calculate(String s) {
        char preSign = '+';
        ArrayDeque<Integer> numStack = new ArrayDeque();
        int num = 0;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            System.out.println(cur+" "+preSign);
            System.out.println(numStack);
            if(Character.isDigit(cur)){
                num = num*10 - '0' + cur;
            }
            System.out.println((!Character.isDigit(cur) && cur !=' ' )|| i == s.length()-1);
            if((!Character.isDigit(cur) && cur !=' ' )|| i == s.length()-1){
                switch(preSign){
                    case '+': numStack.push(num);break;
                    case '-': numStack.push(-num);break;
                    case '*': numStack.push(numStack.pop()*num);break;
                    case '%': numStack.push(numStack.pop()%num);break;
                    case '/': numStack.push(numStack.pop()/num);break;
                }
                System.out.println("after:"+numStack);
                preSign = cur;
                num = 0;
            }
        }
        while(!numStack.isEmpty()){
            result += numStack.pop();
        }
        return result;
    }
    public static void main(String[] args){
        String s = "-3%2+2*2-6/3";
        Calculation2 obj = new Calculation2();
        System.out.println(obj.calculate(s));
        int i = 21;
        int j = -1;
        System.out.println(i&j);
    }
}