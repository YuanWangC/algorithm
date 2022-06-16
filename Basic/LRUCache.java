package Basic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class Node{
    int key;
    int val;
    Node pre;
    Node next;
    public Node(int key,int val) {
        this.key = key;
        this.val = val;
        pre = null;
        next = null;
    }
    public Node(){}
}
public class LRUCache{
    int cap;
    Node head;
    HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(-1,-1);
        map = new HashMap<>();
    }
    public int get(int key) {
        if(map.isEmpty()||!map.containsKey(key))return -1;
        Node n = map.get(key);
//        delete
        n.pre.next = n.next;
        n.next.pre = n.pre;
//        insert
        Node temp = head.next;
        head.next = n;
        n.pre = head;
        temp.pre = n;
        n.next = temp;
        // System.out.println("get traverse:");
        // traverse(head);
        return n.val;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.val = value;
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            Node temp = head.next;
            head.next = cur;
            cur.pre = head;
            temp.pre = cur;
            cur.next = temp;
            map.put(key,cur);
            return;
        }
        Node n = new Node(key,value);
        if(map.size()>=cap){
//            delete last node
            Node delNode = head.pre;
            // System.out.println(delNode.val);
            map.remove(delNode.key,delNode);
            delNode.pre.next = head;
            head.pre = delNode.pre;
        }
//        insert new node
        Node temp = head.next;
        if(temp !=null){
            head.next = n;
            n.pre = head;
            temp.pre = n;
            n.next = temp;
        }
        else{
            head.next = n;
            n.next = head;
            n.pre = head;
            head.pre = n;
        }
        map.put(key,n);
        // System.out.println("put traverse:");
        // traverse(head);
        // System.out.println("put map traverse:");
        // for(Node n1:map.values()){
        //     System.out.println(n1.key+" "+n1.val);
        // }
    }
    public void traverse(Node head){
        Node cur = head.next;
        while(cur!=head){
            System.out.println(cur.key+" "+cur.val);
            cur = cur.next;
        }
    }
    public static void main(String[] args){
        LRUCache obj = new LRUCache(2);
        int param_1 = obj.get(2);
        obj.put(2,3);
        obj.put(3,1);
        param_1 = obj.get(4);
        System.out.println(param_1);
        for(Node n:obj.map.values()){
            System.out.println(n.key+" "+n.val);
        }
        param_1 = obj.get(2);
        System.out.println(param_1);
        obj.put(4,3);
        System.out.println(obj.map);
        for(Node n:obj.map.values()){
            System.out.println(n.key+" "+n.val);
        }
    }
}
class LRUCache2 {
    LinkedHashMap<Integer,Integer> map;
    int cap;
    public LRUCache2(int capacity) {
        cap = capacity;
        map = new LinkedHashMap(capacity);
    }

    public int get(int key) {
        if(map.isEmpty() || !map.containsKey(key))return -1;
        return map.get(key);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            return;
        }
        if(map.size() >= cap){
            int delKey = map.keySet().iterator().next();
            map.remove(delKey);
        }
        map.put(key,value);
    }
//    public static void main(String[] args){
//        LRUCache2 obj = new LRUCache2(2);
//        int param_1 = obj.get(2);
//        obj.put(2,3);
//        obj.put(3,1);
//        param_1 = obj.get(4);
//        System.out.println(param_1+" "+obj.map);
//        obj.put(4,3);
//        System.out.println(obj.map);
//    }
}


