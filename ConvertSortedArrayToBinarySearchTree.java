/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * Tag: Divide and Conquer, DFS
 * 
 * @author joshluo
 * 
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] num) {
        assert (num != null);
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2; // same as (start+end)/2, avoids overflow. This is smart!
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }

}
