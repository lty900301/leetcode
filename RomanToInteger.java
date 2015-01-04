import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Integer http://oj.leetcode.com/problems/roman-to-integer/
 * 
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author joshluo
 * 
 */

public class RomanToInteger {

    /**
     * Cleaner and faster code.
     */
    public int romanToInt(String s) {
        final Map<Character, Integer> romanNumMap = new HashMap<Character, Integer>();
        romanNumMap.put('I', 1);
        romanNumMap.put('V', 5);
        romanNumMap.put('X', 10);
        romanNumMap.put('L', 50);
        romanNumMap.put('C', 100);
        romanNumMap.put('D', 500);
        romanNumMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = romanNumMap.get(s.charAt(i));
            result += currentValue;
            if (i + 1 < s.length()) {
                int nextValue = romanNumMap.get(s.charAt(i + 1));
                if (nextValue > currentValue) { // combine
                    result += (nextValue - 2 * currentValue);
                    i++;
                }
            }
        }
        return result;
    }

    public int romanToInt2(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        // Build the map
        HashMap<Integer, Character> intToRomanMap = new HashMap<Integer, Character>();
        intToRomanMap.put(1, 'I');
        intToRomanMap.put(5, 'V');
        intToRomanMap.put(10, 'X');
        intToRomanMap.put(50, 'L');
        intToRomanMap.put(100, 'C');
        intToRomanMap.put(500, 'D');
        intToRomanMap.put(1000, 'M');
        intToRomanMap.put(5000, '~'); // dummy
        intToRomanMap.put(10000, '~'); // dummy

        int largest = 1000, result = 0, index = 0;
        while (largest > 0) {
            int digitValue = 0;
            while (index < s.length() && s.charAt(index) == intToRomanMap.get(largest)) {
                digitValue++;
                index++;
            }
            if (index < s.length() && s.charAt(index) == intToRomanMap.get(largest * 5)) {
                digitValue = 5 - digitValue;
                index++;
            }
            while (index < s.length() && s.charAt(index) == intToRomanMap.get(largest)) {
                digitValue++;
                index++;
            }
            if (index < s.length() && s.charAt(index) == intToRomanMap.get(largest * 10)) {
                digitValue = 9;
                index++;
            }
            result += digitValue * largest;
            largest /= 10;
        }
        return result;
    }
}
