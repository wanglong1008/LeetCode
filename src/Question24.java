public class Question24 {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head;
        ListNode q=null;
        if(head!=null) q = head.next;
        if (p == null || q == null) return head;
        ListNode result = q;

        p.next = q.next;
        q.next = p;
        ListNode before=p;
        p=p.next;
        if(p!=null) q=p.next;

        while(p!=null&&q!=null){
            p.next = q.next;
            q.next = p;
            before.next=q;
            before=p;
            p=p.next;
            if(p!=null) q=p.next;
        }

        return result;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
