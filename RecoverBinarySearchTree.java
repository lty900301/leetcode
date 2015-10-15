
/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * 
 * This solution will provide O(1) space complexity solution.
 * Reference: http://huntfor.iteye.com/blog/2077665
 * 
 * @author joshluo
 * 
 */
public class RecoverBinarySearchTree {

    TreeNode first, second, pre;

    public void recoverTree(TreeNode root) {
        inOrderTraverse_findMisplacedNodes(root);
        swapValues();
    }

    private void inOrderTraverse_findMisplacedNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraverse_findMisplacedNodes(root.left);
        if (pre != null && root.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        inOrderTraverse_findMisplacedNodes(root.right);
    }

    private void swapValues() {
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}
