/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * 
 * The input string does not contain leading or trailing spaces and the words are always separated by a single
 * space.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsinAString2 {

    public void reverseWords(char[] s) {
        if (s.length == 0)
            return;
        reverse(s, 0, s.length - 1);
        for (int l = 0, r = 0; r < s.length; r++) {
            if (s[r] == ' ') {
                reverse(s, l, r - 1);
                l = r + 1;
            }
        }
    }

    public void reverse(char[] s, int l, int r) {
        while (l <= r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

}
