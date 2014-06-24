import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * @author joshluo
 * 
 * Answer: Consider the slope of a line. And be careful of the points in the same position. O(n^2) algo, 
 * Only iterate afterwards.
 *
 */
public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
        int max = 0;
        for(int i = 0; i < points.length; i++) {
            int x1 = points[i].x, y1 = points[i].y;
            int samePointCount = 1, slopePointCount = 0;; // itself count as 1
            Map<Double, Integer> slopeMap = new HashMap<Double, Integer>();
            for(int j = i + 1; j < points.length; j++) {
                int x2 = points[j].x, y2 = points[j].y;
                if(x2 - x1 == 0 && y2 - y1 == 0) { // if it is a same point
                    samePointCount++;
                } else { // if not add it to the hashmap of slope
                    double slope = 0;
                    if(x2 - x1 == 0) slope = Double.MAX_VALUE; // infinity slope
                    else if(y2 - y1 == 0) slope = 0; // 0 slope, have to specify this, since using double
                    else slope = (double)(y2 - y1) / (double)(x2 - x1);
                    if(!slopeMap.containsKey(slope)) slopeMap.put(slope, 0);
                    slopeMap.put(slope, slopeMap.get(slope) + 1);
                    slopePointCount = Math.max(slopePointCount, slopeMap.get(slope));
                }
            }
            max = Math.max(max, samePointCount + slopePointCount);
        }
        return max;
    }
}
