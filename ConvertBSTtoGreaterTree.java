/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus 
sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
*/

class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        convertBST(root, 0);
        return root;
    }

    private int convertBST(TreeNode root, int val) {
    	if (root == null) return val;
    	int right = convertBST(root.right, val);
    	int left = convertBST(root.left, root.val + right);
    	root.val += right;
    	return left;
    }
}