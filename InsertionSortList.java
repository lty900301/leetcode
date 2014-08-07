/**
 * Sort a linked list using insertion sort.
 * 
 * @author joshluo
 * 
 *         Answer: Iterating through two list. Try saving time when figuring out which one should be re-ordered.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        preHead.next = head;
        while (head != null && head.next != null) {
            if (head.val > head.next.val) { // Figure out which is not in order. Save time!!
                ListNode current = preHead;
                ListNode insertNode = head.next;
                // find position for insertNode
                while (current.next.val <= insertNode.val) {
                    current = current.next;
                }
                ListNode temp = current.next;
                current.next = insertNode;
                head.next = insertNode.next;
                insertNode.next = temp;
            } else {
                head = head.next;
            }
        }
        return preHead.next;
    }
}
