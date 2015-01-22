/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * @author joshluo
 * 
 */
public class JumpGame {

    public boolean canJump(int[] A) {
        assert (A != null);
        if (A.length <= 1) {
            return true;
        }
        int targetIndex = A.length - 1;
        for (int i = A.length - 2; i >= 0; i--) {
            targetIndex = i + A[i] >= targetIndex ? i : targetIndex;
        }
        return targetIndex == 0;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] A = { 3, 2, 1, 0, 4 };
        System.out.println(solution.canJump(A));
    }
}
