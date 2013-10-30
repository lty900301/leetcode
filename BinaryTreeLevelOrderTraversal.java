import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal 
 * http://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 
 * @author joshluo
 *
 */

public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> currentLevel = new ArrayList<Integer>();
        int currentLevelNodes = 1, nextLevelNodes = 0;
        while(queue.size() > 0) {
            TreeNode current = queue.remove();
            currentLevelNodes--;
            currentLevel.add(current.val);
            if(current.left != null) {
                queue.add(current.left);
                nextLevelNodes++;
            }
            if(current.right != null) {
                queue.add(current.right);
                nextLevelNodes++;
            }
            if(currentLevelNodes == 0) {
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                result.add(currentLevel);
                currentLevel = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
