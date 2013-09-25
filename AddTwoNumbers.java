/**
 * Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers. The digits are 
 * stored in reverse order and each of their nodes contain a single digit. Add the two 
 * numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author Josh Luo
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode n1 = l1, n2 = l2;
        ListNode head = new ListNode(0);
        int carry=0;
        ListNode cur = head;
        while (n1 != null && n2 != null) {
            cur.next = new ListNode((n1.val + n2.val + carry)%10);
            carry = (n1.val + n2.val + carry)/10;
            n1 = n1.next;
            n2 = n2.next;
            cur = cur.next;
        }
        ListNode n = null;
        if (n1 == null) {
            n = n2;
        }
        else {
            n = n1;
        }
        while (n != null) {
            cur.next = new ListNode ((n.val + carry)%10);
            carry = (n.val + carry)/10;
            n = n.next;
            cur = cur.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
            cur = cur.next;
        }
        cur.next = null;
        return head.next;
    }
}
