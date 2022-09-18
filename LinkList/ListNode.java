package LinkList;

public class ListNode {
    int value;
    ListNode next;
    public ListNode(){}
    public ListNode(int v){
        this.value = v;
        next = null;
    }
    public static void traverse(ListNode head){
        if(head == null)return;
        ListNode cur = head;
        while (cur!=null){
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
    public static ListNode build(int[] arr,ListNode head){
        head.value = arr[0];
        ListNode cur = head;
        for(int i=1;i<arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
    public  static void main(String[] args){
        ListNode head = new ListNode();
        int[] arr = {1,2,3,4,5};
        head.value = arr[0];
        ListNode cur = head;
        for(int i=1;i<arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        traverse(head);
    }
}
