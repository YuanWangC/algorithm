package LinkList;

public class FindCircle {
    int circleLength = 0;
    public ListNode searchCircleIntro(ListNode head){
//        有环时返回环的入口，无环时返回null
        if(head == null || head.next == null)return null;
        ListNode slow = head,fast =head;
        slow = slow.next;
        fast = fast.next.next;
        while(slow!=fast){
            if(slow==null || fast == null || fast.next == null)return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.value+" "+fast.value);
        slow = head;
//        1.求环的入口：链表头部到环的入口，与相遇点到环的入口是一样长的
//        while(slow!=fast){
//            slow = slow.next;
//            fast = fast.next;
//        }

//        2.或者，增添一步计算环的长度，即：链表头部到相遇点的长度
        while(slow!=fast){
            circleLength++;
            slow = slow.next;
        }

        return slow;
    }
    public static void main(String[] args){
        ListNode head = new ListNode();
        int[] arr = {1,2,3,4,5,6,7,8};
        head.value = arr[0];
        ListNode cur = head;
        for(int i=1;i<arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        cur.next = head.next.next.next;
//        ListNode.traverse(head);
        FindCircle obj = new FindCircle();
        ListNode circle = obj.searchCircleIntro(head);
        System.out.println(circle.value);
        System.out.println(obj.circleLength);
    }
}
