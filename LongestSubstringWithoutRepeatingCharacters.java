/**
 * Longest Substring Without Repeating Characters 
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author Josh Luo
 * 
 * My solution: Time: O(n); Space: O(1)
 * Like two pointer, one is start and one is end. every time it encounters a duplicate the start moves to 
 * the next of that duplicate like "xyzabcadefghij". First, the end will go to 6, and found a duplicate.
 * Current Max Length is (6 - 0) = 6. Then, start moves to 4. And then, end keep moving on.
 * 
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int charSet = 0;
        s = s.toLowerCase();
        
        while(end < s.length()){
        	if(((1 << (s.charAt(end) - 'a')) & charSet) > 0){
        		maxLen = Math.max(maxLen, end - start);
        		for(int k = start; k < end; k++){
        			if(s.charAt(k) == s.charAt(end)){
        				start = k + 1;
        				break;
        			}
        			charSet &= ~(1 << (s.charAt(k) - 'a'));
        		}
        	} else {
        		charSet |= (1 << (s.charAt(end) - 'a'));
        	}
        	end++;
        }
        return Math.max(end - start, maxLen);
    }
}
