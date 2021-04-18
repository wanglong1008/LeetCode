import java.util.*;

public class Question142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set=new HashSet<ListNode>() ;
        if(head==null) return null;
        ListNode p=head;
        while(p!=null){
            if(!set.contains(p)) {
                set.add(p);
                p = p.next;
            }
            else {
                return p;
            }
        }
        return null;
    }
}
