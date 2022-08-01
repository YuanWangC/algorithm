/*
    删除链表的倒数第n个节点
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = n;
//        使用虚构的头结点，防止删除头结点
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        //    出于删除头结点需要
        ListNode cur = dummyhead;
        ListNode start = dummyhead,pre = null;
//        从k=n数到k=1为止
        while(k>1){
            k--;
            cur = cur.next;
        }
        // System.out.println(cur.val);
        while(cur.next!=null){
            // System.out.println(cur.val+" "+start.val);
            pre = start;
            start = start.next;
            cur = cur.next;
        }
        pre.next = start.next;
        return dummyhead.next;
    }
    public static void main(String[] args){
        ListNode head1 = new ListNode();
        int[] arr1 = {1,2,4};
        head1 = ListNode.build(arr1,head1);
        RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
        ListNode res = obj.removeNthFromEnd(head1,3);
        ListNode.traverse(res);
    }
}