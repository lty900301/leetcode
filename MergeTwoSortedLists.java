/**
 * Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 * 
 * @author Josh Luo
 * 
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; next =
 * null; } }
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode beforeResult = new ListNode(0);
        ListNode result = beforeResult;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (l1 != null)
            result.next = l1;
        if (l2 != null)
            result.next = l2;
        return beforeResult.next;
    }
}
