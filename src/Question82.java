public class Question82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) return head;
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode pre = p;
        ListNode cur =head;
        boolean flag=false;
        while(cur!=null){
            while(cur.next!=null&&cur.next.val==cur.val){
                flag=true;
                if(cur.next.next==null) {pre.next=null; return p.next;}
                cur=cur.next;

            }
            if(flag==false) {
                pre = cur;
                cur = cur.next;
            }
            else{
                pre.next = cur.next;
                cur = cur.next;
            }
            flag=false;
        }
        return p.next;
    }
}
