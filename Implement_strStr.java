/**
 * Implement strStr()
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * 
 * @author Josh Luo
 * 
 *         For each char in haystack, match the whole needle string. O(m * n).
 */

public class Implement_strStr {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        assert (haystack != null && needle != null);
        if (needle.length() == 0)
            return haystack;
        for (int i = 0; i < haystack.length(); i++) {
            if ((haystack.length() - i) < needle.length())
                break;
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                j++;
            }
            if (j == needle.length())
                return haystack.substring(i);
        }
        return null;
    }
}
