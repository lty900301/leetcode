import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Word Ladder 2
 * http://oj.leetcode.com/problems/word-ladder-ii/
 * 
 * Given two words (start and end), and a dictionary, find all shortest transformation 
 * sequence(s) from start to end, such that:
 * 1. Only one letter can be changed at a time
 * 2. Each intermediate word must exist in the dictionary
 * 
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * Return
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 * @author joshluo
 * @reference http://discuss.leetcode.com/questions/1051/word-ladder-ii?focusedAnswerId=2468&sort=votes&page=2
 */

public class WordLadder2 {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.

	    // method would be similar, except that, we need to store the path
	    // in addition, if we get the result, we didn't stop until we finish
	    // all the path of the same length
	    // visited map the string to the list of its ancestor
	    HashMap<String, HashSet<String>> visited=new HashMap<String, HashSet<String>>();
	    HashMap<String, Integer> level=new HashMap<String, Integer>();
	    Queue<String> queue=new LinkedList<String>();
	    ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
	    if (start==null || end==null || start.length()!=end.length())
	    {
	        return result;
	    }
	    // we also need to store the path from the start
	    HashSet<String> path=new HashSet<String>();
	    // we record the minimal length we get
	    int min_length=Integer.MAX_VALUE;
	    visited.put(start, path);
	    level.put(start, 1);
	    queue.add(start);
	    while(!queue.isEmpty())
	    {
	        String s=queue.remove();
	        char[] chars=s.toCharArray();
	        for (int i=0; i<s.length(); i++)
	        {
	            char old=chars[i];
	            for (char c='a'; c<='z'; c++)
	            {
	                chars[i]=c;
	                String s2=new String(chars);
	                // avoid circle
	                // check whether it is in the dictionary
	                // we only add the string which is nearer to the start
	                if (dict.contains(s2) && (!level.containsKey(s2) || (level.containsKey(s2) && level.get(s2)>level.get(s))))
	                {
	                    // we update the ancestor of the string
	                    if (visited.containsKey(s2))
	                    {
	                        visited.get(s2).add(s);
	                    }
	                    else
	                    {
	                        // we haven't seen this node before
	                        // thus we add it to the queue and also its ancestor
	                        path=new HashSet<String>();
	                        path.add(s);
	                        visited.put(s2, path);
	                        level.put(s2, level.get(s)+1);
	                        queue.add(s2);
	                    }
	                }
	                if (s2.equals(end))
	                {
	                    // we found it
	                    // we will use back trace to found its path to start
	                    if (level.get(s)<min_length)
	                    {
	                        // it is shortest path
	                        ArrayList<String> entry=new ArrayList<String>();
	                        entry.add(end);
	                        result.addAll(back_trace(s, visited, entry));
	                        min_length=level.get(s)+1;
	                    }
	                    else
	                    {
	                        // ok, all the remaining path should be longer
	                        break;
	                    }
	                }
	            }
	            chars[i]=old;
	        }
	    }
	    return result;
	}

	private ArrayList<ArrayList<String>> back_trace(String end, HashMap<String, HashSet<String>> visited, ArrayList<String> path)
	{
	    ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
	    ArrayList<String> entry=new ArrayList<String>(path);
	    entry.add(0, end);
	    if (visited.get(end).size()<1)
	    {
	        result.add(entry);
	        return result;
	    }
	    for (String str: visited.get(end))
	    {
	        result.addAll(back_trace(str, visited, entry));
	    }
	    return result;
	}
	
	// Memory Limit Exceeded
//	public static ArrayList<ArrayList<String>> findLadders(
//			String start, String end, HashSet<String> dict){
//        // IMPORTANT: Please reset any member data you declared, as
//		// the same Solution instance will be reused for each test case.
//		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
//		if(dict == null || dict.size() == 0 || start.length() != end.length()) 
//			return result;
//		dict.add(end);
//
//        HashSet<String> visited = new HashSet<String>();
//        
//		ArrayList<ArrayList<ArrayList<String>>> threeDArray = 
//				new ArrayList<ArrayList<ArrayList<String>>>();
//        ArrayList<String> path = new ArrayList<String>(); 
//        path.add(start);
//        ArrayList<ArrayList<String>> firstLevel = new ArrayList<ArrayList<String>>();
//        firstLevel.add(path);
//        threeDArray.add(firstLevel);
//        
//        Queue<String> queue = new LinkedList<String>();
//        queue.add(start);
//        visited.add(start);
//        int level = 0;
//        int currentLevelNodesNum = 1, nextLevelNodesNum = 0, currentLevelTotal = 1;
//        boolean found = false;
//        ArrayList<ArrayList<String>> nextLevelArray = new ArrayList<ArrayList<String>>();
//        while(!queue.isEmpty()) {
//        	String front = queue.remove();
//        	ArrayList<String> frontPath = 
//        			threeDArray.get(level).get(currentLevelTotal - currentLevelNodesNum);
//        	currentLevelNodesNum--;
//        	if(front.equals(end)) {
//        		result.add(frontPath);
//        		found = true;
//        	}
//        	
//        	for(int i = 0; i < front.length(); i++) {
//        		StringBuffer sb = new StringBuffer(front);
//        		for(char c = 'a'; c < 'z'; c++) {
//        			if(front.charAt(i) == c) continue;
//        			sb.setCharAt(i, c);
//        			String next = sb.toString();
//        			if(dict.contains(next) && 
//        					(!visited.contains(next) || next.equals(end))) {
//        				ArrayList<String> parentPathArrayList = deepCopyArray(frontPath);
//        				parentPathArrayList.add(next);
//        				nextLevelArray.add(parentPathArrayList);
//        				queue.add(next);
//        				visited.add(next);
//        				nextLevelNodesNum++;
//        			}
//        		}
//        	}
//        	
//        	visited.clear();
//        	visited.add(start);
//        	
//        	if(currentLevelNodesNum == 0) {
//        		if (found) break;
//        		level++;
//        		currentLevelNodesNum = nextLevelNodesNum;
//        		currentLevelTotal = currentLevelNodesNum;
//        		nextLevelNodesNum = 0;
//        		threeDArray.add(nextLevelArray);
//        		nextLevelArray = new ArrayList<ArrayList<String>>();
//        	}
//        }
//        return result;
//    }
//	
//	public static ArrayList<String> deepCopyArray(ArrayList<String> input) {
//		if(input == null) return input;
//		ArrayList<String> result = new ArrayList<String>();
//		Iterator<String> iter = input.iterator();
//		while(iter.hasNext())
//			result.add(iter.next());
//		return result;
//	}
}
