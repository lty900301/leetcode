/**
 * Sum Root to Leaf Numbers
 * http://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could 
 * represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author joshluo
 *
 */

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null) {
            return 0;
        }
        return sum(root, 0);
    }
    
    // DFS
    public int sum(TreeNode root, int prev) {
        if (root.left == null && root.right == null) {
            return 10 * prev + root.val;
        } 
        int result = 0;
        if (root.left != null) {
            result += sum(root.left, 10 * prev + root.val);
        }
        if(root.right != null) {
            result += sum(root.right, 10 * prev + root.val);
        }
        return result;
    }
}
