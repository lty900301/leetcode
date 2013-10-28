import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Word Ladder
 * http://oj.leetcode.com/problems/word-ladder/
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest 
 * transformation sequence from start to end, such that:
 * 	1. Only one letter can be changed at a time
 * 	2. Each intermediate word must exist in the dictionary
 * 
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 * @author joshluo
 *
 */

public class WordLadder {
	
	// BFS
	public int ladderLength(String start, String end, HashSet<String> dict) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if(dict == null || dict.size() == 0 ||
        		start.length() != end.length()) return 0;
        if(start.length() == 0 || end.length() == 0) return 1;
        
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        int level = 0, currentLevelNodesNum = 1, nextLevelNodesNum = 0;
        boolean found = false;
        while(!queue.isEmpty()) {
        	String front = queue.remove();
        	currentLevelNodesNum--;
        	if(front.equals(end)) {
        		level++;
        		found = true;
        		break;
        	}
        	
        	for(int i = 0; i < front.length(); i++) {
        		StringBuffer sb = new StringBuffer(front);
        		for(char c = 'a'; c < 'z'; c++) {
        			if(sb.charAt(i) == c) continue;
        			sb.setCharAt(i, c);
        			String next = sb.toString();
        			if(dict.contains(next) && !visited.contains(next)) {
        				queue.add(next);
        				visited.add(next);
        				nextLevelNodesNum++;
        			}
        		}
        	}
        	
        	if(currentLevelNodesNum == 0) {
        		level++;
        		currentLevelNodesNum = nextLevelNodesNum;
        		nextLevelNodesNum = 0;
        	}
        }
        return found ? level : 0;
	}
	
	
	// DFS
	// exceed time limit
//	public int ladderLength(String start, String end, HashSet<String> dict) {
//        // IMPORTANT: Please reset any member data you declared, as
//        // the same Solution instance will be reused for each test case.
//        if(dict == null || dict.size() == 0 ||
//        		start.length() != end.length()) return 0;
//        if(start.length() == 0 || end.length() == 0) return 1;
//        
//        int diffNum = 0;
//        for(int i = 0; i < start.length(); i++) {
//            if(start.charAt(i) != end.charAt(i)) diffNum++;
//        }
//        if(diffNum < 2) return 2;
//        
//        HashSet<String> copiedDict = new HashSet<String>();
//        Iterator<String> iter = dict.iterator();
//        while(iter.hasNext()){
//            String copied = iter.next();
//            copiedDict.add(copied);
//        }
//        
//        int minLen = Integer.MAX_VALUE;
//        for(int i = 0; i < start.length(); i++) {
//            for(int j = 0; j < 26; j++){
//                char replace = (char) ('a' + j);
//                if(replace == start.charAt(i)) continue;
//                StringBuilder sb = new StringBuilder();
//                sb.append(start.substring(0, i));
//                sb.append(replace);
//                if(i < (start.length()-1))sb.append(start.substring(i+1, start.length()));
//                String nextStart = sb.toString();
//                if(copiedDict.contains(nextStart)){
//	                copiedDict.remove(nextStart);
//	                int nextLength = ladderLength(nextStart, end, copiedDict);
//	                if(nextLength > 0) minLen = Math.min(minLen, nextLength + 1);
//                }
//            }
//        }
//        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
//    }
}
