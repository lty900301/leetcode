/**
 * Container With Most Water 
 * http://oj.leetcode.com/problems/container-with-most-water/
 * 
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at 
 * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i 
 * is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author Josh Luo
 * 
 * This problem is very interesting. You need to think through that the smaller height is 
 * actually the bottle-neck of that area, so you have to move the smaller height forward.
 */

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        assert(height != null); 
        int i = 0, j = height.length - 1, maxArea = 0;
        while(i < j) {
            int area = 0;
            if(height[i] < height[j]) {
                area = height[i] * (j - i);
                i++;
            } else {
                area = height[j] * (j - i);
                j--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
