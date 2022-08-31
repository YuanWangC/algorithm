import java.util.Deque;
import java.util.LinkedList;

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxInQueue obj = new MaxInQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */

public class MaxInQueue {
    Deque<Integer> que1;
    Deque<Integer> que2;
    public MaxInQueue() {
        que1 = new LinkedList<>();
        que2 = new LinkedList<>();
    }

    public int max_value() {
        if(que1.isEmpty())return -1;
        return que2.peek();
    }

    public void push_back(int value) {
        while(!que2.isEmpty() && que2.peekLast()<value){
            que2.removeLast();
        }
        que2.addLast(value);
        que1.addLast(value);
    }

    public int pop_front() {
        if(que1.isEmpty())return -1;
        int val1 = que1.removeFirst();
        int val2 = que2.peek();
        if(val1==val2){
            que2.removeFirst();
        }
        return val1;
    }
    public static void main(String[] args){
        MaxInQueue obj = new MaxInQueue();
        int value = 1;
        int param_1 = obj.max_value();
        System.out.println(param_1);
        obj.push_back(value);
        int param_3 = obj.pop_front();
        System.out.println(param_3);
        value = 2;
        obj.push_back(value);
        int param_4 = obj.pop_front();
        System.out.println(param_4);
    }
}

