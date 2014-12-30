/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in polynomial time complexity.
 * 
 * Solution: Focus on how many 5's in the decomposition(25 => 5 * 5) formation of factorial. There are enough 2's in the
 * equation (1-5 has two 2's).
 * 
 * @author joshluo
 * 
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int result = 0;
        if (n <= 0) {
            return result;
        }
        int power = 1, key = 5;
        double currentKey = 5;
        do {
            currentKey = Math.pow(key, power++);
            result += n / currentKey;
        } while (n >= currentKey);
        return result;
    }

    public static void main(String args[]) {
        final FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        System.out.println(factorialTrailingZeroes.trailingZeroes(25));
    }
}
