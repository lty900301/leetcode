/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the
 * original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * @author joshluo
 * 
 */
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode ahead = head, behind = pre;
        while (ahead != null) {
            while (ahead.next != null && behind.next.val == ahead.next.val) {
                ahead = ahead.next;
            }
            if (ahead == behind.next) {
                behind = behind.next;
            } else {
                behind.next = ahead.next;
            }
            ahead = ahead.next;
        }
        return pre.next;
    }

}
