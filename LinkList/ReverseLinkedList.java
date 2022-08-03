public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        if(cur == null)return head;
        ListNode n = cur.next;
        head.next = null;
        if(n == null)return head;
        while(n!=null){
            ListNode n2 = n.next;
            n.next = cur;
            cur = n;
            n = n2;
        }
        return cur;
    }
    public static void main(String[] args){
        ReverseLinkedList object= new ReverseLinkedList();
        int[] arr = {1,2,3,4,5};
        ListNode head = ListNode.build(arr,new ListNode());
        ListNode newHead = object.reverseList(head);
        ListNode.traverse(newHead);
    }
}