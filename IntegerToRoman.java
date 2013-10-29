import java.util.HashMap;

/**
 * Integer to Roman
 * http://oj.leetcode.com/problems/integer-to-roman/
 * 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Josh Luo
 *
 */

public class IntegerToRoman {
	public String intToRoman(int num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(num < 1 || num > 3999) return null;
        
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
        
        // Transfer
        StringBuilder sb = new StringBuilder();
        int largest = 1000;
        while (num > 0) {
            int digitValue = num / largest;
            if(digitValue > 0) {
                String translated = digitToRoman(
                    digitValue, intToRomanMap.get(largest * 5), intToRomanMap.get(largest));
                if(translated.isEmpty()) {
                    sb.append(intToRomanMap.get(largest));
                    sb.append(intToRomanMap.get(largest * 10));
                } else {
                    sb.append(translated);
                }
            }
            num -= digitValue * largest;
            largest /= 10;
        }
        return sb.toString();
    }
    
    public String digitToRoman(int digitValue, char fiveChar, char c) {
        StringBuilder sb = new StringBuilder();
        if(digitValue <= 3) {
            sb.append(numsChar(digitValue, c));
        } else if(digitValue == 4) {
            sb.append(c);
            sb.append(fiveChar);
        } else if(digitValue == 5) {
            sb.append(fiveChar);
        } else if(digitValue < 9) {
            sb.append(fiveChar);
            sb.append(numsChar(digitValue - 5, c));
        } else {
        }
        return sb.toString();
    }
    
    public String numsChar(int nums, char c) {
        StringBuilder sb = new StringBuilder();
        while(nums > 0) {
            sb.append(c);
            nums--;
        }
        return sb.toString();
    }
}
