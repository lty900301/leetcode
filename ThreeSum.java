import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Three Sum
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
 * The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * @author Josh Luo
 *
 */

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, Integer> valueNumberMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            if(valueNumberMap.containsKey(num[i])){
                valueNumberMap.put(num[i], valueNumberMap.get(num[i]) + 1);
                continue;
            }
            valueNumberMap.put(num[i], 1);
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        
        for(int i = 0; i < num.length;){
            int first = num[i];
            
            for(int j = i+1; j < num.length;){
                int second = num[j];
                
                int third = 0 - first - second;
                if(third < second) {
                    while(j < num.length && second == num[j]) j++;
                    continue;
                }
                
                valueNumberMap.put(first, valueNumberMap.get(first) - 1);
                valueNumberMap.put(second, valueNumberMap.get(second) - 1);
                if(valueNumberMap.containsKey(third) && valueNumberMap.get(third) > 0){
                    ArrayList<Integer> oneResult = new ArrayList<Integer>();
                    oneResult.add(first);
                    oneResult.add(second);
                    oneResult.add(third);
                    result.add(oneResult);
                }
                valueNumberMap.put(first, valueNumberMap.get(first) + 1);
                valueNumberMap.put(second, valueNumberMap.get(second) + 1);
                
                while(j < num.length && second == num[j]) j++;
            }
            while(i < num.length && first == num[i]) i++;
        }
        return result;
    }
}
