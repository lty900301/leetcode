/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * Solution reference: http://fisherlei.blogspot.com/2013/04/leetcode-permutation-sequence-solution.html
 * 
 * @author joshluo
 * 
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] digits = new int[n];
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            digits[i - 1] = i;
            factorial *= n;
        }
        k--; // change K from (1,n) to (0, n-1) to accord to index
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            int chosed = k / factorial;
            result.append(digits[chosed]);
            // restruct nums since one num has been picked
            for (int j = chosed; j < n - i; j++) {
                digits[j] = digits[j + 1];
            }
            k = k % factorial;
        }
        return result.toString();
    }

}
