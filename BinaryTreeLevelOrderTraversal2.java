import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level
 * by level from leaf to root).
 * 
 * <code>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9   20
 *      /  \
 *     15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * </code>
 * 
 * Solution: Simple BFS
 * 
 * @author joshluo
 * 
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int toVisit = root == null ? 0 : 1;
        List<Integer> level = new ArrayList<Integer>();
        while (toVisit > 0) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            toVisit--;
            if (toVisit == 0) {
                toVisit = queue.size();
                result.add(0, level);
                level = new ArrayList<Integer>();
            }
        }
        return result;
    }

}
