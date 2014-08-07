import java.util.ArrayList;

/**
 * Letter Combinations of a Phone Number http://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Input:Digit string "23" Output:
 * ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
 * 
 * @author joshluo
 * 
 *         Simple algorithm. Just use simple BFS method, a little different than usual.
 */

public class LetterCombinationsOfAPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert (digits != null);
        ArrayList<String> res = new ArrayList<String>();
        res.add("");
        if (digits.isEmpty())
            return res;
        int index = 0;
        while (index < digits.length()) {
            int digit = digits.charAt(index) - '0';
            index++;
            if (digit == 0)
                continue;
            ArrayList<Character> allChar = getAllChar(digit);
            ArrayList<String> tempRes = new ArrayList<String>();
            while (res.size() > 0) {
                String s = res.remove(0);
                for (char c : allChar) {
                    tempRes.add(s + c);
                }
            }
            res.addAll(tempRes);
        }
        return res;
    }

    ArrayList<Character> getAllChar(int digit) {
        int base = (digit - 2) * 3;
        ArrayList<Character> res = new ArrayList<Character>();
        if (digit == 7)
            base = 'p' - 'a';
        if (digit == 8)
            base = 't' - 'a';
        if (digit == 9)
            base = 'w' - 'a';
        res.add((char) ('a' + base));
        res.add((char) ('a' + base + 1));
        res.add((char) ('a' + base + 2));
        if (digit == 7 || digit == 9)
            res.add((char) ('a' + base + 3));
        return res;
    }
}
