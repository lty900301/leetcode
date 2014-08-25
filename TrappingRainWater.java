/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
 * it is able to trap after raining.
 * 
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * http://www.leetcode.com/wp-content/uploads/2012/08/rainwatertrap.png
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 * section) are being trapped. Thanks Marcos for contributing this image!
 * 
 * @author joshluo
 * 
 *         An O(n) solution is to consider each bar at a time, we can see that, for each bar, the water itself can trap
 *         depends on the max height on its left and right, e.g. if current bar is of height 2, the max height on its
 *         left is 4, max height on its right is 3, then water can be trapped in this bar is min(4,3)-2 = 1.
 * 
 *         Thus, we can scan the whole map twice to get the max height on right and left, respectively. Finally scan the
 *         map again to get the water trapped of all.
 * 
 */
public class TrappingRainWater {

    public int trap(int[] A) {
        int result = 0;
        if (A == null || A.length == 0) {
            return result;
        }
        // Left max for every pivot
        int[] leftMax = new int[A.length];
        leftMax[0] = 0;
        for (int i = 1; i < A.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);
        }
        // right max for every pivot
        int[] rightMax = new int[A.length];
        rightMax[rightMax.length - 1] = 0;
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A[i + 1]);
            int trappedWater = Math.min(leftMax[i], rightMax[i]) - A[i];
            result += trappedWater > 0 ? trappedWater : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(A));
    }
}
