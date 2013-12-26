/**
 * Remove Duplicates from Sorted Array
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Given a sorted array, remove the duplicates in place such that each element appear only once 
 * and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * 
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * @author JoshLuo
 *
 */

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) return 0;
        int val = A[0], loc = 0; // loc keep the index of new array
        for(int index = 0; index < A.length; index++){
        	if(val != A[index]) {
        		val = A[index];
        		A[++loc] = val;
        	}
        }
        return loc + 1;
    }
}
