import java.util.ArrayDeque;
/*
带括号的加减乘除取余计算器
思路：
     其实把所有的计算都看成加法，无非是加正数，加负数的问题。
     遇到乘除法我们就原地计算成一个新的被加数。
     遇到括弧就原地递归得出一个新的被加数。
 */
public class Calculation3 {
    public int calculate(String s) {
        //去空格
        s = s.replaceAll(" ", "");
        if (s.length() == 0) return 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();//数据栈
        char sign = '+'; //符号
        int res = 0, pre = 0, i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            //处理两位数的问题
            if (Character.isDigit(ch)) {
                pre = pre*10+(ch-'0');
            }
            //碰到左括号 就把括号里面当成一个新的被加数，递归计算
            if (ch == '(') {
                int j = findClosing(s.substring(i));
                pre = calculate(s.substring(i+1, i+j));
                i += j;
            }
            if (i == s.length()-1 || !Character.isDigit(ch)) {
                //将所有的结果压栈,最后统一加起来
                switch (sign) {
                    case '+': stack.push(pre); break;
                    case '-': stack.push(-pre); break;
                    case '*': stack.push(stack.pop()*pre); break;
                    case '/': stack.push(stack.pop()/pre); break;
                    case '%': stack.push(stack.pop()%pre); break;
                }
                pre = 0;
                //记录当前的符号
                sign = ch;
            }
            i++;
        }
        // 本质上说全都是加法
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }

    //找到最外层的括号对，取得右括号的位置
    private int findClosing(String s) {
        int level = 0, i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') level++;
            else if (s.charAt(i) == ')') {
                level--;
                if (level == 0) break;
            } else continue;
        }
        return i;
    }
    public static void main(String[] args){
        String s = "(3*(3-1)+2*(1+1))*2-6%3";
        Calculation3 obj = new Calculation3();
        System.out.println(obj.calculate(s));
    }
}