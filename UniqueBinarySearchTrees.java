import org.junit.Assert;
import org.junit.Test;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's. <code>
 * 1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * </code>
 * 
 * Reference:
 * http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
 * http://blog.csdn.net/linhuanmars/article/details/24761459
 * 
 * f(0) = 1
 * f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ... + f(n-2)*f(1) + f(n-1)*f(0)
 * 
 * @author joshluo
 * 
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        int result[] = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - 1 - j];
            }
        }
        return result[n];
    }

    @Test
    public void test() {
        Assert.assertEquals(numTrees(3), 5);
    }
}
