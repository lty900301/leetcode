import java.util.Stack;

/**
 * Longest Valid Parantheses
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * @author joshluo
 * 
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> lefts = new Stack<Integer>();
        int maxLen = 0, last = -1; // last record the beginning of the valid string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lefts.push(i);
            } else {
                if (lefts.isEmpty()) {
                    last = i; // avoid all the useless "("
                } else {
                    lefts.pop();
                    if (lefts.isEmpty()) { // there is a valid match from the last beginning
                        maxLen = Math.max(maxLen, i - last);
                    } else { // The valid match is from where the left '(' begins
                        maxLen = Math.max(maxLen, i - lefts.peek());
                    }
                }
            }
        }
        return maxLen;
    }

    public static void main(String args[]) {
    }
}
