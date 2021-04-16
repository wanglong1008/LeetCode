import java.util.*;

public class Question138 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        List<Node> list=new ArrayList<>();
        HashMap<Node,Integer> map=new HashMap<>();
        Node p=head;
        int num=0;
        Node pre=new Node(0);
        while(p!=null){
            Node cur=new Node((p.val));
            pre.next=cur;
            list.add(cur);
            map.put(p,num);
            pre=cur;
            num++;
            p=p.next;
        }
        p=head;
        num=0;
        while(p!=null){
            if(p.random==null){
                list.get(num).random=null;
            }
            else{
                Node v=p.random;
                int index=map.get(v);
                list.get(num).random=list.get(index);
            }
            p=p.next;
            num++;
        }
        return list.get(0);
    }
}
