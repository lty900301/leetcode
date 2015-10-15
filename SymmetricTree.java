
/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center). <code>
 * 
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * </code> <br>
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * @author joshluo
 * 
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == null && right == null;
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}
