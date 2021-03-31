import java.util.*;

public class Question92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        Stack<ListNode> stack=new Stack<>();
        ListNode a=new ListNode(0);
        ListNode p=a;
        ListNode q=head;
        ListNode pre=null;
        for(int i=1;i<m;i++){
            pre=q;
            q=q.next;
        }
        for(int j=m;j<=n;j++){
            stack.push(q);
            q=q.next;
        }
        while(!stack.empty()){
            p.next=stack.pop();
            p=p.next;
        }
        p.next=q;
        if(pre==null){
            return a.next;
        }
        else{
            pre.next=a.next;
            return head;
        }
    }
}
