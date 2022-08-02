public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        if(cur1==null && cur2 == null)return null;
        if(cur1 == null)return cur2;
        if(cur2 == null)return cur1;
        ListNode head;
//        此处由于第一个节点已经比较完毕，不再重复进行比较
        if(l2.value<l1.value){
            head = l2;
            cur2 = cur2.next;
        }
        else {
            head = l1;
            cur1 = cur1.next;
        }
        ListNode cur3 = head;
        while(cur1!=null && cur2!=null){
            if(cur1.value<cur2.value){
//                此处cur1转移到next位置上，保存了后续节点信息
                cur3.next = cur1;
                cur1 = cur1.next;
            }
            else{
                cur3.next = cur2;
                cur2 = cur2.next;
            }
            cur3 = cur3.next;
        }
        if(cur2!=null){
            cur3.next = cur2;
        }
        else if(cur1!=null){
            cur3.next = cur1;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode head1 = new ListNode();
        int[] arr1 = {1,2,4};
        head1 = ListNode.build(arr1,head1);
        ListNode head2 = new ListNode();
        int[] arr2 = {1,3,4};
        head2 = ListNode.build(arr2,head2);
        MergeTwoLists obj = new MergeTwoLists();
        ListNode res = obj.mergeTwoLists(head1,head2);
        ListNode.traverse(res);
    }
}