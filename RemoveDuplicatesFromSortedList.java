/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author joshluo
 * 
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head, p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            if (p1.val == p2.val) {
                continue;
            }
            if (p1.val < p2.val) {
                throw new IllegalArgumentException("Linked list is not sorted.");
            }
            p2.next = p1;
            p2 = p1;
        }
        p2.next = null;
        return head;
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l1 = new RemoveDuplicatesFromSortedList().deleteDuplicates(l1);
        while (l1.next != null) {
            System.out.print(l1.val + " -> ");
            l1 = l1.next;
        }
        System.out.println(l1.val);
    }
}
