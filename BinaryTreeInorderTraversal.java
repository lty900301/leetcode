import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3}, <code>
 * 1
 *  \
 *   2
 *  /
 * 3
 * </code> return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 * Common error:
 * Time Limit Exceeded. Forget to remove the left child after left child already been added to stack.
 * 
 * Reference: http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
 * 
 * @author joshluo
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            if (curNode == null) {
                continue;
            }
            if (curNode.left != null) {
                stack.push(curNode);
                stack.push(curNode.left);
                curNode.left = null;
            } else {
                result.add(curNode.val);
                stack.push(curNode.right);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null) {
            inorderTraversal_recursive(root, result);
        }
        return result;
    }

    private void inorderTraversal_recursive(TreeNode root, List<Integer> result) {
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        if (root.left != null) {
            inorderTraversal_recursive(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversal_recursive(root.right, result);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        Integer[] expectedResult = { 2, 1 };
        Assert.assertArrayEquals(expectedResult, new BinaryTreeInorderTraversal().inorderTraversal_iterative(root)
                .toArray());
    }

}
