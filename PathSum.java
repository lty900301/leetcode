
/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
 * the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * @author joshluo
 * 
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return nodeSum(root, 0, sum);
    }

    private boolean nodeSum(TreeNode node, int sum, int target) {
        if (node == null)
            return false;
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum == target;
        }

        return nodeSum(node.left, sum, target) || nodeSum(node.right, sum, target);
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        System.out.println(pathSum.hasPathSum(root, 1));
    }
}
