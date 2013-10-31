import java.util.ArrayList;

/**
 * Palindrome Partitioning
 * http://oj.leetcode.com/problems/palindrome-partitioning/
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 * @author joshluo
 *
 */

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(s == null) return result;
		ArrayList<String> temp = new ArrayList<String>();
		return partition(s, temp);
    }
	
	public ArrayList<ArrayList<String>> partition(String s, ArrayList<String> prev) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		if(s.isEmpty()) {
			result.add(prev);
			return result;
		}
		
		// O(n^2)
		for (int i = 1; i <= s.length(); i++) { // O(n)
			String sub = s.substring(0, i);
			if (isPalindrome(sub)) { // O(n)
				ArrayList<String> current = new ArrayList<String>();
				current.addAll(prev);
				current.add(sub);
				result.addAll(partition(s.substring(i), current));
			}
		}
		return result;
    }
    
    public boolean isPalindrome(String s) {
		if(s.length() == 0) return false;
		int start = 0, end = s.length() - 1;
		while(start <= end) {
			if(s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}
