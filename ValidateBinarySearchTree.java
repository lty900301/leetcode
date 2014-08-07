/**
 * Validate Binary Search Tree http://oj.leetcode.com/problems/validate-binary-search-tree/#
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows: 1. The left subtree of a node contains only nodes with keys less than the node's
 * key. 2. The right subtree of a node contains only nodes with keys greater than the node's key. 3. Both the left and
 * right subtrees must also be binary search trees.
 * 
 * OJ's Binary Tree Serialization: The serialization of a binary tree follows a level order traversal, where '#'
 * signifies a path terminator where no node exists below.
 * 
 * Here's an example: 1 / \ 2 3 / 4 \ 5
 * 
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 * 
 * @author Josh Luo
 * 
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int minBound, int maxBound) {
        if (root == null)
            return true;
        if (root.val <= minBound)
            return false;
        if (root.val >= maxBound)
            return false;
        return isValidBST(root.left, minBound, root.val) && isValidBST(root.right, root.val, maxBound);
    }
}
