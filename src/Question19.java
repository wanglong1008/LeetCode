public class Question19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = head, b = head;
        int step = 1;
        while (b.next != null) {
            if (step <= n) {
                b = b.next;
                step++;
            } else {
                a = a.next;
                b = b.next;
            }
        }
        if (a == head && step == n) {
            head = head.next;
        } else {
            a.next = a.next.next;
        }
        return head;
    }


}
/**
 * 定义链表节点
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}