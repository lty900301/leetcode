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
        
        int index = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != elem) {
                A[index] = A[i];
                index++;
            }
        }
        int[] backup = A;
        A = new int[index];
        for(int i = 0; i < A.length; i++) {
            A[i] = backup[i];
        }
        return A.length;
    }
}
