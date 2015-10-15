/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * Solution: Use two pointers.
 * 
 * @author JoshLuo
 * 
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        assert (s != null);
        if (s.isEmpty()) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
