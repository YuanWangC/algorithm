public class ListDelete {
    public ListNode del1(ListNode head,int target){
        if(head == null)return head;
        ListNode cur = head;
        while(cur.value!=target){
            cur = cur.next;
        }
        if(cur == null)return null;
        if(cur.next==null){
            cur = null;
        }
        else{
            ListNode n = cur.next;
            cur.value = n.value;
            cur.next = n.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        int[] arr = {1,2,3};
        head.value = arr[0];
        ListNode cur = head;
        for(int i=1;i<arr.length;i++){
            cur.next= new ListNode(arr[i]);
            cur = cur.next;
        }
        ListDelete obj = new ListDelete();
        ListNode c = obj.del1(head,2);
        while(c!=null){
            System.out.println(c.value);
            c= c.next;
        }
    }
}
