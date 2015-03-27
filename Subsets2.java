import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If S = [1,2,2], a solution is: <code>
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ] </code>
 * 
 * Reference: http://blog.csdn.net/linhuanmars/article/details/24613193
 * 
 * @author joshluo
 * 
 */
public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] num) {
        assert (num != null);
        Arrays.sort(num);
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        int start = 0;
        for (int i = 0; i < num.length; i++) {
            int size = subsets.size();
            for (int j = start; j < size; j++) {
                ArrayList<Integer> subset = new ArrayList<Integer>(subsets.get(j));
                subset.add(num[i]);
                subsets.add(subset);
            }
            if (i < num.length - 1 && num[i] == num[i + 1]) {
                start = size;
            } else {
                start = 0;
            }
        }
        return subsets;
    }

    public static void main(String args[]) {
        int[] num = { 1, 2, 2 };
        System.out.println(new Subsets2().subsetsWithDup(num));
    }

}
