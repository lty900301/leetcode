import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 * 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * 
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * 
 * Reference: http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * Reference: http://fisherlei.blogspot.com/2012/12/leetcode-largest-rectangle-in-histogram.html
 * 
 * @author joshluo
 * 
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] height) {
        assert (height != null);
        Stack<Integer> incrementIndexes = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= height.length; i++) {
            // We add another bar in the end, which is height 0. So that we can clean indexes in stack in the end
            int currentHeight = i == height.length ? 0 : height[i];
            if (incrementIndexes.empty() || currentHeight > height[incrementIndexes.peek()]) {
                incrementIndexes.push(i);
            } else {
                int index = incrementIndexes.pop();
                // if all previous bar are higher than this one, width is i - 0
                // else we find the previous lower bar's height: previousLowBarHeight, width that meets current height
                // is (i - 1 - previousLowBarHeight)
                int widthForHeight = incrementIndexes.empty() ? i : (i - 1 - incrementIndexes.peek());
                maxArea = Math.max(maxArea, height[index] * widthForHeight);
                i--; // stay in here until we calculate all indexes in the stack
            }
        }
        return maxArea;
    }

}
