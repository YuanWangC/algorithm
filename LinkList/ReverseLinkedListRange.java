public class ReverseLinkedListRange {
//    头插法
    private synchronized ListNode reverseList(ListNode head, int left, int right) {
        ListNode dummyhead = new ListNode();
        dummyhead.next = head;
        int pos = 1;
        ListNode pre = dummyhead;
        ListNode cur = head;
        while(pos<left && cur!=null){
            cur = cur.next;
            pre = pre.next;
            pos++;
        }
//        注意此处，不可以继续移动cur。cur的next指针在变化，下一个元素会自己补上来，可以有效翻转
        while (cur!=null && pos<right){
            ListNode nextNode = cur.next;
            cur.next = nextNode.next;
//            头插法，放到pre节点后面
            nextNode.next = pre.next;
            pre.next = nextNode;
            pos++;
        }
        return dummyhead.next;
    }
    public static void main(String[] args){
        ReverseLinkedListRange object= new ReverseLinkedListRange();
        int[] arr = {1,2,3,4,5};
        int leftpos = 2;
        int rightpos = 4;
        ListNode head = ListNode.build(arr,new ListNode());
        ListNode newHead = object.reverseList(head,leftpos,rightpos);
        ListNode.traverse(newHead);
    }
}
