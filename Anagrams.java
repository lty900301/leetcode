import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Anagrams
 * http://oj.leetcode.com/problems/anagrams/
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 * @author joshluo
 *
 */

public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(strs.length < 2) return new ArrayList<String>();
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for(String str : strs) {
            char[] strArray = str.toCharArray();
            Arrays.sort(strArray);
            String key = new String(strArray);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            ArrayList<String> anagrams = map.get(key);
            anagrams.add(str);
        }
        
        ArrayList<String> result = new ArrayList<String>();
        for(String key : map.keySet()) {
            ArrayList<String> anagrams = map.get(key);
            if(anagrams.size() > 1) {
                result.addAll(anagrams);            
            }
        }
        
        return result;
    }
}
