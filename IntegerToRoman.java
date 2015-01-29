import java.util.HashMap;
import java.util.Map;

/**
 * Integer to Roman http://oj.leetcode.com/problems/integer-to-roman/
 * 
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Josh Luo
 * 
 */

public class IntegerToRoman {

    public String intToRoman(int num) {
        assert (num > 0);

        Map<Integer, String> intToRoman = new HashMap<Integer, String>();
        intToRoman.put(1, "I");
        intToRoman.put(5, "V");
        intToRoman.put(10, "X");
        intToRoman.put(50, "L");
        intToRoman.put(100, "C");
        intToRoman.put(500, "D");
        intToRoman.put(1000, "M");

        StringBuilder result = new StringBuilder();
        for (int i = 1000; i >= 1; i /= 10) {
            int times = num / i;
            if (times <= 3) {
                result.append(numsChar(times, intToRoman.get(i)));
            } else if (times == 4) {
                result.append(intToRoman.get(i)).append(intToRoman.get(i * 5));
            } else if (times >= 5 && times <= 8) {
                result.append(intToRoman.get(i * 5));
                result.append(numsChar(times - 5, intToRoman.get(i)));
            } else if (times == 9) {
                result.append(intToRoman.get(i)).append(intToRoman.get(i * 10));
            } else {
                throw new RuntimeException("not allowed");
            }
            num %= i;
        }
        return result.toString();
    }

    public String numsChar(int nums, String c) {
        StringBuilder sb = new StringBuilder();
        while (nums > 0) {
            sb.append(c);
            nums--;
        }
        return sb.toString();
    }

}
