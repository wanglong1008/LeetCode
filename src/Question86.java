public class Question86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        ListNode a=new ListNode(0);
        ListNode cur=a;
        ListNode b=new ListNode(0);
        b.next=head;
        ListNode p=b;
        ListNode q=head;
        while(q!=null){
            if(q.val<x){
                cur.next=q;
                cur=cur.next;
                p.next=q.next;
                q=q.next;
            }
            else{
                p=q;
                q=q.next;
            }
        }
       cur.next=b.next;
        return a.next;
    }
}
