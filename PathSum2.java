import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum. <br>
 * <code>
 * For example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 * </code>
 * 
 * @author joshluo
 * 
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> branch = new ArrayList<Integer>();
        branch.add(root.val);
        pathSum(result, branch, root, sum - root.val);
        return result;
    }

    private void pathSum(List<List<Integer>> result, List<Integer> branch, TreeNode root, int sum) {
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<Integer>(branch));
            return;
        }
        if (root.left != null) {
            branch.add(root.left.val);
            pathSum(result, branch, root.left, sum - root.left.val);
            branch.remove(branch.size() - 1);
        }
        if (root.right != null) {
            branch.add(root.right.val);
            pathSum(result, branch, root.right, sum - root.right.val);
            branch.remove(branch.size() - 1);
        }
    }

}
