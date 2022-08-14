public class Midpoint {
    public static ListNode find(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args){
        ListNode head = new ListNode();
//        int[] arr = {1,2,3,4,5,6,7};  //奇数个走到中点，fast走到最后一个（fast.next==null）
        int[] arr = {1,2,3,4,5,6};  //偶数个走到第二个中点，fast走到最后一个的next(fast==null)
        ListNode.build(arr,head);
        System.out.println(Midpoint.find(head).value);
    }
}
