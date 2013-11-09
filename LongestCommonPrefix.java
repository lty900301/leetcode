/**
 * Longest Common Prefix 
 * http://oj.leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author joshluo
 * 
 * Really easy problem.
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert(strs != null);
        if(strs.length == 0) return "";
        String longest = strs[0];
        for(String str : strs) {
            int i = 0;
            while(i < Math.min(longest.length(), str.length())){
                if(longest.charAt(i) != str.charAt(i)) break;
                i++;
            }
            longest = longest.substring(0, i);
        }
        return longest;
    }
}
