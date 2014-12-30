import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 *  
 * Solution:
 * 
 *     0.16
 * 6 ) 1.00
 *     0
 *     1 0 <-- Remainder=1, mark 1 as seen at position=0.
 *     - 6
 *       40 <-- Remainder=4, mark 4 as seen at position=1.
 *     - 36
 *        4 <-- Remainder=4 was seen before at position=1,        
 * so the fractional part which is 16 starts repeating at position=1 => 1(6).
 *        
 * The key insight here is to notice that once the remainder starts repeating, so does the divided result.
 * 
 * You will need a hash table that maps from the remainder to its position of the fractional part. Once you found a
 * repeating remainder, you may enclose the reoccurring fractional part with parentheses by consulting the position from
 * the table.
 * 
 * The remainder could be zero while doing the division. That means there is no repeating fractional part and you should
 * stop right away.
 * 
 * Just like the question Divide Two Integers, be wary of edge case such as negative fractions and nasty extreme case
 * such as -2147483648 / -1.
 * 
 * Difficulty: Very Hard.
 * 
 * @author joshluo
 */
public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
            return null;
        if (numerator == 0)
            return "0";

        StringBuilder result = new StringBuilder((numerator > 0 ^ denominator > 0) ? "-" : "");

        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);

        // int part
        result.append(num / den);
        // decimal part
        long remainder = num % den * 10; // remainder should increase
        if (remainder != 0) {
            result.append(".");
        }
        Map<Long, Integer> loopBeginLocByRemainder = new HashMap<Long, Integer>();
        while (remainder != 0) {
            if (loopBeginLocByRemainder.containsKey(remainder)) {
                int beginLoc = loopBeginLocByRemainder.get(remainder);
                result.insert(beginLoc, "(");
                result.append(")");
                return result.toString();
            }
            loopBeginLocByRemainder.put(remainder, result.length());
            result.append(remainder / den);
            remainder = (remainder % den) * 10; // remainder should increase
        }
        return result.toString();
    }

    public static void main(String args[]) {
        final FractionToRecurringDecimal fractionToRecurringDecimal = new FractionToRecurringDecimal();
        System.out.println(fractionToRecurringDecimal.fractionToDecimal(2, 3));
    }
}
