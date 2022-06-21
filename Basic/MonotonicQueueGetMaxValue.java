package Basic;

import java.util.Deque;
import java.util.LinkedList;

public class MonotonicQueueGetMaxValue {
    Deque<Integer> que;
    Deque<Integer> temp;
    int max = -1;
    public MonotonicQueueGetMaxValue() {
        que = new LinkedList<>();
        temp = new LinkedList<>();
    }

    public int max_value() {
        if(this.que.isEmpty())return -1;
        return temp.peek();
    }

    public void push_back(int value) {
        que.offer(value);
        while(!temp.isEmpty() && temp.getLast()<value){
            temp.removeLast();
        }
        temp.offer(value);
    }

    public int pop_front() {
        if(que.isEmpty())return -1;
        int max = temp.getFirst();
        int cur = que.poll();
        if(cur == max)temp.poll();
        return cur;
    }
    public static void main(String[] args){
        MonotonicQueueGetMaxValue obj = new MonotonicQueueGetMaxValue();
        obj.push_back(1);
        obj.push_back(2);
        int param_1 = obj.max_value();
        System.out.println(param_1);
        int param_3 = obj.pop_front();
        System.out.println(param_3);
        param_1 = obj.max_value();
        System.out.println(param_1);
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */