import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * @author Josh Luo
 */

/**
 * Definition for an interval.
 */
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }

public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(intervals == null || intervals.isEmpty()) return intervals;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start)
                    return -1;
                else if (i1.start > i2.start)
                    return 1;
                else {
                    if (i1.end < i2.end)
                        return -1;
                    else if (i1.end > i2.end)
                        return 1;
                    else
                        return 0;
                }
            }
        };
        Collections.sort(intervals, comparator);

        ArrayList<Interval> merged = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
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