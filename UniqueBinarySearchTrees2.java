import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below. <code>
 * 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * </code>
 * 
 * Reference: http://blog.csdn.net/linhuanmars/article/details/24761437
 * 
 * @author joshluo
 * 
 */
public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }

}
