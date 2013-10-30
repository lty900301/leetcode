/**
 * Longest Palindromic Substring
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume that the 
 * maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * @author http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html
 *
 *
 */

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        // a single char itself is a palindrome
        String longest = s.substring(0, 1);  
        for (int i = 0; i < n-1; i++) {
        	// odd
            String p1 = expandAroundCenter(s, i, i);
            if (p1.length() > longest.length())
            	longest = p1;
            
            // even
            String p2 = expandAroundCenter(s, i, i+1);
            if (p2.length() > longest.length())
            	longest = p2;
        }
        return longest;
    }
	
	String expandAroundCenter(String s, int c1, int c2) {
        int l = c1, r = c2;
        int n = s.length();
        while (l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

	// Amazing O(n)
	public String longestPalindrome2(String s) {
		String T = preProcess(s);
		int n = T.length();
		int[] P = new int[n];
		int C = 0, R = 0;
		for (int i = 1; i < n-1; i++) {
			int i_mirror = 2*C-i; // equals to i' = C - (i-C)
			P[i] = (R > i) ? Math.min(R-i, P[i_mirror]) : 0;
			
			// Attempt to expand palindrome centered at i
			while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
				P[i]++;
			
			// If palindrome centered at i expand past R,
			// adjust center based on expanded palindrome.
			if (i + P[i] > R) {
				C = i;
				R = i + P[i];
			}
		}
		  
		// Find the maximum element in P.
		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < n-1; i++) {
			if (P[i] > maxLen) {
				maxLen = P[i];
				centerIndex = i;
			}
		}
		return s.substring((centerIndex - 1 - maxLen)/2, maxLen + (centerIndex - 1 - maxLen)/2);
	}

    // Transform S into T.
	// For example, S = "abba", T = "^#a#b#b#a#$".
	// ^ and $ signs are sentinels appended to each end to avoid bounds checking
	String preProcess(String s) {
	int n = s.length();
	if (n == 0) return "^$";
	String ret = "^";
	for (int i = 0; i < n; i++)
		ret += "#" + s.substring(i, 1);
	ret += "#$";
	return ret;
	}
}
