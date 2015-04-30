import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place. <br>
 * 
 * <code>
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * </code>
 * 
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order
 * traversal.
 * 
 * @author joshluo
 * 
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode runner = root;
        while (runner != null || !stack.isEmpty()) {
            if (runner.right != null) {
                stack.push(runner.right);
            }
            if (runner.left != null) {
                runner.right = runner.left;
                runner.left = null;
            } else if (!stack.isEmpty()) {
                runner.right = stack.pop();
            }
            runner = runner.right;
        }
    }

}
