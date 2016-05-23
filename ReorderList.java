/**
 * Given a singly linked list L: L0->L1->…->Ln-1->Ln,
 * reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * Reference: http://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/
 * @author JoshLuo
 * 
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 1. Break list in the middle to two lists (use fast & slow pointers)
        ListNode secondHead = getSecondHalf(head);
        // 2. Reverse the order of the second list
        secondHead = reverseOrder(secondHead);
        // 3. Merge two list one by one.
        mergeList(head, secondHead);
    }

    private ListNode getSecondHalf(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null; // Close first half.
        return secondHead;
    }

    private ListNode reverseOrder(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        head.next = null;
        return pre;
    }

    private void mergeList(ListNode L1, ListNode L2) {
        while (L2 != null) {
            ListNode L1next = L1.next;
            ListNode L2next = L2.next;
            L1.next = L2;
            L2.next = L1next;
            L1 = L1next;
            L2 = L2next;
        }
    }

}
