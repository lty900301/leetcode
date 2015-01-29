/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @author joshluo
 * 
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0)
            return head;
        ListNode p = head;
        int len = 1;// since p is already point to head
        while (p.next != null) {
            len++;
            p = p.next;
        }
        p.next = head; // form a loop
        n = n % len;
        for (int i = 0; i < len - n; i++) {
            p = p.next;
        } // now p points to the prev of the new head
        head = p.next;
        p.next = null;
        return head;
    }

}
