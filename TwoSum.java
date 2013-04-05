/**
 * Given an array of integers, find two numbers such that they add up to a specific target 
 * number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to 
 * the target, where index1 must be less than index2. Please note that your returned 
 * answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * @author XYuser
 *
 */

import java.util.*;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
         
        int[] x = new int[2];
 
        HashMap<Integer, Integer> indexes = new HashMap<Integer, Integer>();
 
        for (int k = 0; k < numbers.length; k++) {
            if (!indexes.containsKey(numbers[k])) {
                indexes.put(numbers[k], k+1);
            }
        //duplicates cannot be solutions unless they sum up to target 
            else if (numbers[k] * 2 == target) {
                x[0] = indexes.get(numbers[k]);
                x[1] = k+1;
                return x;
            }
        }
        
        for(int i = 0; i < numbers.length; i++){
            if(indexes.containsKey(numbers[i])){
                int index1 = indexes.get(numbers[i]);
                if(indexes.containsKey(target - numbers[i])){
                    int index2 = indexes.get(target - numbers[i]);
                    x[0] = Math.min(index1, index2);
                    x[1] = Math.max(index1, index2);
                    return x;
                }
            }
        }
 
        return x;
    }
}