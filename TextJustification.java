import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully
 * (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 * 
 * @author joshluo
 * 
 */
public class TextJustification {

    private static final String SPACE = " ";
    private static final String EMPTY = "";

    public List<String> fullJustify(String[] words, int L) {
        assert (words != null && L >= 0);
        List<String> result = new ArrayList<String>();
        if (L == 0) {
            result.add(EMPTY);
            return result;
        }
        List<Integer> toInsertIndex = new ArrayList<Integer>();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            if (word.length() > L) {
                throw new RuntimeException("Word lengh larger than limit");
            } else if (toInsertIndex.isEmpty()) {
                // First word
                line.append(word);
                toInsertIndex.add(line.length());
            } else {
                int currentLength = line.length() + SPACE.length() + word.length();
                if (currentLength < L) {
                    // still room to fit this word
                    line.append(SPACE).append(word);
                    toInsertIndex.add(line.length());
                } else if (currentLength == L) {
                    // Just fit into this line. Conclude this line and reset array
                    line.append(SPACE).append(word);
                } else {
                    // Cannot fit. Distribute the trailing spaces
                    int spaces = L - line.length();
                    if (toInsertIndex.size() > 1) {
                        // more than one word, Last index does not append space
                        toInsertIndex.remove(toInsertIndex.size() - 1);
                    }
                    // distribute spaces. HARDEST PART!
                    int k = 0;
                    for (int j = 0; j < spaces; j++) {
                        line.insert(toInsertIndex.get(k), SPACE);
                        k = (k + 1) % toInsertIndex.size();
                        toInsertIndex.set(k, toInsertIndex.get(k) + k);
                    }
                    // redo this word in next line
                    i--;
                }
            }
            // RE-START off a new line.
            if (line.length() == L) {
                result.add(line.toString());
                toInsertIndex.clear();
                line = new StringBuilder();
            }

        }
        // HANDLE LAST LINE: If last line is less than L. We append rest of spaces
        if (toInsertIndex.size() > 0 && line.length() < L) {
            int num_spaces = L - line.length();
            for (int j = 0; j < num_spaces; j++) {
                line.append(SPACE);
            }
            result.add(line.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        TextJustification solution = new TextJustification();
        String[] words = { "Listen", "to", "many,", "speak", "to", "a", "few." };
        List<String> result = solution.fullJustify(words, 6);
        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }

}
