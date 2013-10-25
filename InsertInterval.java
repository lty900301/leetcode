import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the 
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to 
 * their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
 * [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author Josh Luo
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(intervals == null) return intervals;
        int i = 0;
        while(i < intervals.size() && newInterval.start > intervals.get(i).start){
            i++;
        }
        intervals.add(i, newInterval);
        
        ArrayList<Interval> merged = new ArrayList<Interval>();
        for (int j = 0; j < intervals.size(); j++) {
        	Interval cur = intervals.get(j);
            if (merged.isEmpty()) {
                merged.add(cur);
            } else {
                Interval last = merged.get(merged.size() - 1);
                if (last.end >= cur.start) {
                    last.end = Math.max(last.end, cur.end);
                } else {
                    merged.add(cur);
                }
            }
        }
        
        return merged;
    }
}
