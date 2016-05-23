import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * 
 * For example, given two 1d vectors:
 * 
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2,
 * 4, 5, 6].
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * 
 * Clarification for the follow up question - Update (2015-09-18): The "Zigzag" order is not clearly defined and is
 * ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given
 * the following input:
 * 
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * It should return [1,4,8,2,5,9,3,6,7].
 * 
 * http://blog.csdn.net/xudli/article/details/48749219
 * 
 */
public class ZigzagIterator implements Iterator<Integer> {

    private final List<Iterator<Integer>> iterList;
    private int iterIndex;

    public ZigzagIterator(List<Integer>... vs) {
        assert (vs != null);
        iterList = new ArrayList<Iterator<Integer>>();
        for (List<Integer> v : vs) {
            if (v != null) {
                iterList.add(v.iterator());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !iterList.isEmpty();
    }

    @Override
    public Integer next() {
        int next = iterList.get(iterIndex).next();
        if (!iterList.get(iterIndex).hasNext()) {
            iterList.remove(iterIndex);
        } else {
            iterIndex++;
        }
        if (!iterList.isEmpty()) {
            iterIndex %= iterList.size();
        }
        return next;
    }

}
