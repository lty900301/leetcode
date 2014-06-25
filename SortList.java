

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author joshluo
 * 
 * Answer: Using divide and conquer (merge)
 *
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
    	// count the total number of this list, and find the middle index
		int count = 0;
		ListNode p = head;
		while(p != null) {
			count++;
			p = p.next;
		}
		int midIndex = count / 2;
		// Find the left and right head
		ListNode leftHead = head;
		ListNode leftTail = head;
		for(int i = 0; i < midIndex - 1; i++) {
			// Find out the left tail
			leftTail = leftTail.next;
		}
		ListNode rightHead = leftTail.next;
		leftTail.next = null; // Clear the left tail
		
		return merge(sortList(leftHead), sortList(rightHead));
    }
	
	public ListNode merge(ListNode leftHead, ListNode rightHead) {
		ListNode l = leftHead, r = rightHead, preHead = new ListNode(0);
		ListNode ptr = preHead;
		while(l != null && r != null) {
			if(l.val < r.val) {
				ptr.next = l;
				l = l.next;
			} else {
				ptr.next = r;
				r = r.next;
			}
			ptr = ptr.next;
		}
		if(l != null) {
			ptr.next = l;
		} else {
			ptr.next = r;
		}
		return preHead.next;
	}
}
