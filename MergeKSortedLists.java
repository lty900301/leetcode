import java.util.ArrayList;

/**
 * Merge k Sorted Lists http://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merge k sorted linked lists and return it as one sorted list.
 * 
 * Analyze and describe its complexity. Assume there are k sorted lists and there are total n nodes in these lists. Then
 * the complexity is (k*n)
 * 
 * @author Josh Luo
 * 
 */

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (lists == null || lists.size() == 0)
            return null;
        ListNode resultPrev = new ListNode(0);
        ListNode current = resultPrev;
        int nextHead = findNextSmallest(lists);
        while (nextHead >= 0) {
            current.next = lists.get(nextHead);
            current = current.next;
            lists.set(nextHead, current.next);
            nextHead = findNextSmallest(lists);
        }
        return resultPrev.next;
    }

    public int findNextSmallest(ArrayList<ListNode> lists) {
        int index = -1, smallest = Integer.MAX_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            ListNode next = lists.get(i);
            if (next == null)
                continue;
            if (next.val < smallest) {
                smallest = next.val;
                index = i;
            }
        }
        return index;
    }
}
