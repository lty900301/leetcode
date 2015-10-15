
/**
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 
 * <pre>
 *   1
 *  / \
 * 2   3
 * </pre>
 * 
 * Solution Reference:
 * http://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/
 * 
 * @author JoshLuo
 * 
 */
public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateSum(root);
        return max;
    }

    public int calculateSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = calculateSum(root.left);
        int right = calculateSum(root.right);
        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max = Math.max(max, Math.max(current, left + root.val + right));
        return current;
    }

}
