import java.util.Stack;

/**
 * Valid Parentheses
 * http://oj.leetcode.com/problems/valid-parentheses/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 * 
 * @author joshluo
 *
 * Easy one, use stack. O(n), n is the length of input String.
 */

public class ValidParentheses {
	public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert(s != null);
        Stack<Character> stack = new Stack<Character>();
        int index = 0;
        while(index < s.length()) {
        	if(s.charAt(index) == '(' || s.charAt(index) == '[' || s.charAt(index) == '{') {
        		stack.push(s.charAt(index));
        	} else if(s.charAt(index) == ')') {
        		if(stack.isEmpty() || stack.peek() != '(') return false;
        		stack.pop();
        	} else if(s.charAt(index) == ']') {
        		if(stack.isEmpty() || stack.peek() != '[') return false;
        		stack.pop();
        	} else if(s.charAt(index) == '}') {
        		if(stack.isEmpty() || stack.peek() != '{') return false;
        		stack.pop();
        	}
        	index++;
        }
        
        if(stack.isEmpty()) return true;
        return false;
    }
}
