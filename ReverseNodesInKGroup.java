import org.junit.Test;

/**
 * Reverse Nodes in K-Group http://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5 For k = 2, you should return: 2->1->4->3->5 For k = 3, you should
 * return: 3->2->1->4->5
 * 
 * @author JoshLuo
 * @reference http://discuss.leetcode.com/answer_link/1827/
 */

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 0)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 0; head.next != null; i++) {
            if (i % k == 0)
                head.next = reverse(head.next, k);
            head = head.next;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        // Forward to find the number of nodes in list
        ListNode last = head;
        int loc = 0;
        while (last != null && loc < k) {
            last = last.next;
            loc++;
        }
        if (loc < k)
            return head; // The list length is less than k
        // Forward to reverse the list
        ListNode cur = head.next;
        head.next = last;
        while (loc > 1) {
            // Swap from behind to front
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
            loc--;
        }
        return head;
    }

    @Test
    public void test() {
        int k = 2; // Set up for the k
        // Initial set up 1->2->3->4->5->6->7
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        ListNode h6 = new ListNode(6);
        ListNode h7 = new ListNode(7);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;
        h7.next = null;

        ListNode result = reverseKGroup(h1, k);
        while (result != null) {
            if (result.next != null)
                System.out.print(result.val + "->");
            else
                System.out.print(result.val);
            result = result.next;
        }
    }
}
