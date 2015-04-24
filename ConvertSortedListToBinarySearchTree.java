import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Reference: http://leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html
 * 
 * @author joshluo
 * 
 */
public class ConvertSortedListToBinarySearchTree {

    private ListNode head;

    /**
     * Complexity: O(n). Space O(1)
     */
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        ListNode runner = head;
        int count = 0;
        while (runner != null) {
            count++;
            runner = runner.next;
        }
        return sortedListToBST(0, count - 1);
    }

    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head = head.next;
        root.right = sortedListToBST(mid + 1, end);
        return root;
    }

    class ConvertSortedListToBinarySearchTree_Array {

        /**
         * Complexity: O(n). Space O(n)
         */
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> num = new ArrayList<Integer>();
            while (head != null) {
                num.add(head.val);
                head = head.next;
            }
            return sortedArrayToBST(num, 0, num.size() - 1);
        }

        /**
         * Refer to {@link ConvertSortedArrayToBinarySearchTree#sortedArrayToBST(int[])}
         */
        private TreeNode sortedArrayToBST(List<Integer> num, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = start + (end - start) / 2; // same as (start+end)/2, avoids overflow. This is smart!
            TreeNode root = new TreeNode(num.get(mid));
            root.left = sortedArrayToBST(num, start, mid - 1);
            root.right = sortedArrayToBST(num, mid + 1, end);
            return root;
        }

    }
}
