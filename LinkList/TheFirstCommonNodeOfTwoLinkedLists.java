package LinkList;

public class TheFirstCommonNodeOfTwoLinkedLists {
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA,cur2 = headB;
        if(cur1 == null || cur2==null)return null;
        while(cur1!=cur2){
//            注意cur是选择next还是下一个节点的头部，控制在一次操作中
            if(cur1 == null)cur1 = headB;
            else cur1 = cur1.next;
            if(cur2==null)cur2 = headA;
            else cur2 = cur2.next;
        }
        return cur1;
    }
    public static void main(String[] args){
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {3,4,5};
        ListNode.build(arr1,head1);
        ListNode.build(arr2,head2);
        head2.next.next.next = head1.next.next.next.next.next;
        ListNode com = TheFirstCommonNodeOfTwoLinkedLists.getIntersectionNode(head1,head2);
        System.out.println(com.value);
    }
}