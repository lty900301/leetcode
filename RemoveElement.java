/**
 * Remove Element
 * http://oj.leetcode.com/problems/remove-element/
 * 
 * Given an array and a value, remove all instances of that value in place and 
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the 
 * new length.
 * 
 * @author joshluo
 *
 */

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int i = 0, j = 0;
        while(i < A.length) {
            if(A[i] == elem) {
                i++;
                continue;
            }
            if(i < A.length) A[j++] = A[i++];
        }
        return j;
    }
}
