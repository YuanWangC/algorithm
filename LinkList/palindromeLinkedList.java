package LinkList;

public class palindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)return true;
        ListNode fast = head;
        ListNode slow = head,pre = null;
        while(fast!=null && fast.next!=null){
            fast =fast.next.next;
//            保存下一个节点
            ListNode temp = slow.next;
//            调转指针
            slow.next = pre;
//            节点继续移动
            pre = slow;
            slow = temp;
        }
//        如果fast非空，走到了奇数个的中点处，则跳过这个点
        if(fast!=null){
            slow = slow.next;
        }
        if(slow==null)return false;
//        比较重构的两条链表节点是否相同
        while(pre!=null && slow!=null){
            if(pre.value!=slow.value)return false;
            pre = pre.next;
            slow = slow.next;
        }
        if(pre==null && slow==null)return true;
        return false;
    }
    public static void main(String[] args){
        ListNode head = new ListNode();
//        int[] arr = {1,2,3,4,3,2,1};  //奇数个走到中点，fast走到最后一个（fast.next==null）
        int[] arr = {1,2,3,3,2,1};  //偶数个走到第二个中点，fast走到最后一个的next(fast==null)
        ListNode.build(arr,head);
        System.out.println(palindromeLinkedList.isPalindrome(head));
    }
}
