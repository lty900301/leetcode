/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * My solution: Time: O(n^2); Space: O(1)
 * 
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        while(s.length() - start >= maxLen){
            int charSet = 0;
            end = start;
            while(end < s.length()){
                char endC = s.toLowerCase().charAt(end);
                if(((1 << (endC - 'a')) & charSet) > 0)
                    break;
                charSet |= 1 << (endC - 'a');
                end++;
            }
            if(maxLen < (end - start)) maxLen = end - start;
            start++;
        }
        return maxLen;
    }
}
