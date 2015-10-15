
/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 * 
 * @author joshluo
 * 
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left), right = depth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

}
