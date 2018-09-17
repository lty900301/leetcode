/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same
 * parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left
 * leaf nodes. Return the new root.
 * 
 * For example: <code>
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * 
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *     4
 *    / \
 *   5   2
 *      /  \
 *     3    1
 * </code>
 */
public class BinaryTreeUpsideDown {
    /*
     * http://blog.csdn.net/whuwangyi/article/details/43186045
     * https://leetcode.com/discuss/62263/explain-the-question-and-my-solution-python
     */
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        TreeNode left = root.left, right = root.right;
        TreeNode newRoot = UpsideDownBinaryTree(left);
        left.left = right;
        left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
