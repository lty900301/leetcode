import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between). <br>
 * <code>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </code>
 * 
 * @author joshluo
 * 
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return result;
        queue.add(root);
        boolean reversedOrder = false;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                TreeNode n = queue.poll();
                if (reversedOrder)
                    level.add(0, n.val);
                else
                    level.add(n.val);
                if (n.left != null)
                    queue.add(n.left);
                if (n.right != null)
                    queue.add(n.right);
            }
            result.add(level);
            reversedOrder = !reversedOrder;
        }
        return result;
    }

}
