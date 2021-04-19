public class Question148 {
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        //ListNode preEnd=new ListNode(Integer.MIN_VALUE);
        ListNode small=new ListNode(0);
        ListNode s1=small;
        ListNode big=new ListNode(0);
        ListNode b1=big;
        ListNode p=head;
        while(p.next!=null){
            if(p.next.val<head.val){
                //  if(p.next.val>preEnd.val) preEnd=p.next;
                s1.next=p.next;
                s1=s1.next;
            }
            else{
                b1.next=p.next;
                b1=b1.next;

            }
            p=p.next;
        }
        s1.next=null;
        b1.next=null;
        head.next=null;

        ListNode p1=sortList(small.next);
        ListNode p2=sortList(big.next);
        s1=p1;
        if(p1!=null) {
            while(s1.next!=null){
                s1=s1.next;
            }
            //    preEnd.next = head;
            s1.next=head;
            head.next = p2;
            return p1;
        }
        else{
            head.next = p2;
            return head;
        }
    }
}
