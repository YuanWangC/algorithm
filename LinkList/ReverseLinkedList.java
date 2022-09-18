package LinkList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null)return head;
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode n = cur.next;
            cur.next = pre;
            pre = cur;
            cur = n;
        }
        return pre;
    }
    public static void main(String[] args){
        ReverseLinkedList object= new ReverseLinkedList();
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.build(arr,new ListNode());
        ListNode newHead = object.reverseList(head);
        ListNode.traverse(newHead);
    }
}