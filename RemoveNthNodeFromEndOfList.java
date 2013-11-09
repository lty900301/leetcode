/**
 * Remove Nth Node From End of List 
 * http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * @author Josh Luo
 * Easy traverse the Linked List. O(n).
 */

public class RemoveNthNodeFromEndOfList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert(head != null);
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode start = prev;
        ListNode end = head;
        while(n-- > 0) {
        	end = end.next;
        }
        while(end != null) {
        	start = start.next;
        	end = end.next;
        }
        start.next = start.next.next;
        return prev.next;
    }
	
	public static void main(String args[]) {
		ListNode root = new ListNode(1);
		root = removeNthFromEnd(root, 1);
		while(root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}
}
