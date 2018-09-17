/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  
Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length at most 12.
S will consist only of letters or digits.
*/

class LetterCasePermutation {

	// initial thinking is using DFS recursion
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList();
        letterCasePermutation(result, S, new StringBuilder());
        return result;
    }

    private void letterCasePermutation(List<String> result, String S, StringBuilder sb) {
    	if (sb.length() == S.length()) {
    		result.add(sb.toString());
    		return;
    	}
    	char c = S.charAt(sb.length());
    	if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
    		sb.append(Character.toLowerCase(c));
    		letterCasePermutation(result, S, new StringBuilder(sb));

    		sb.deleteCharAt(sb.length() - 1);
    		sb.append(Character.toUpperCase(c));
    		letterCasePermutation(result, S, new StringBuilder(sb));
    	} else {
    		sb.append(c);
    		letterCasePermutation(result, S, new StringBuilder(sb));
    	}
    }

    // Option 2 is to use BFS
    public List<String> letterCasePermutation2(String S) {
        if (S == null) {
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) continue;            
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chs = cur.toCharArray();
                
                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
                
                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        
        return new LinkedList<>(queue);
    }

}