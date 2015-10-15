/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * @author tianyil
 * 
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        ListNode n1 = head;
        ListNode n2 = head;
        while (n1 != null && n1.next != null) {
            n1 = n1.next.next;
            n2 = n2.next;
            if (n1 == n2) {
                n2 = head;
                while (n1 != n2) {
                    n1 = n1.next;
                    n2 = n2.next;
                }
                return n1;
            }
        }
        return null;
    }

}
