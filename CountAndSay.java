/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author joshluo
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 0; i < n - 1; i++) {
            result = generateNextSequence(result);
        }
        return result;
    }

    private String generateNextSequence(String currentSequence) {
        char[] original = currentSequence.toCharArray();
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < original.length) {
            int value = original[index] - '0';
            int count = 1;
            while (++index < original.length && value == (original[index] - '0')) {
                count++;
            }
            result.append(count).append(value);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        final CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(9));
    }
}
