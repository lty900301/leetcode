/**
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * 
 * @author joshluo
 * 
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }
        char base = (char) ('A' - 1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(s.length() - 1 - i);
            result += (c - base) * Math.pow(26, i);
        }
        return result;
    }

}
