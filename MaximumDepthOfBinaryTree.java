import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * @author joshluo
 * 
 */
public class MaximumDepthOfBinaryTree {

    // BFS
    public int maxDepth(TreeNode root) {
        int level = 0;
        if (root == null) {
            return level;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int toVisit = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            toVisit--;
            if (toVisit == 0) {
                level++;
                toVisit = queue.size();
            }
        }
        return level; // according to the maximum depth definition
    }

}
