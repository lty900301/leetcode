

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * @author joshluo
 * 
 */
public class SameTree {

    /**
     * Use traverse to see if two trees are the same.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == null && q == null;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
