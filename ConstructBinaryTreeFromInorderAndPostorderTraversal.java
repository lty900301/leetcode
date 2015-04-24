import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * @author joshluo
 * 
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        assert (inorder != null && postorder != null && inorder.length == postorder.length);
        Map<Integer, Integer> inOrderLocByVal = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderLocByVal.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inOrderLocByVal);
    }

    private TreeNode buildTree(int[] postorder, int postL, int postR, int[] inorder, int inL, int inR,
            Map<Integer, Integer> inOrderLocByVal) {
        if (postL > postR || inL > inR)
            return null;
        TreeNode root = new TreeNode(postorder[postR]);
        int index = inOrderLocByVal.get(root.val);
        root.left = buildTree(postorder, postL, postL + index - inL - 1, inorder, inL, index - 1, inOrderLocByVal);
        root.right = buildTree(postorder, postR - (inR - index), postR - 1, inorder, index + 1, inR, inOrderLocByVal);
        return root;
    }

    @Test
    public void test() {
        int[] inorder = { 1, 2 };
        int[] postorder = { 2, 1 };
        buildTree(inorder, postorder);
    }
}
