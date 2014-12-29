/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * 
 * @author joshluo
 * 
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n < 1) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int offset = (n - 1) % 26;
            sb.insert(0, (char) ('A' + offset));
            n = n / 27;
        }
        return sb.toString();
    }
}
