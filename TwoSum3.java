import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * 
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * 
 * For example,
 * 
 * add(1);
 * add(3);
 * add(5);
 * find(4) -> true
 * find(7) -> false
 */
public class TwoSum3 {

    private final Map<Integer, Integer> map;

    public TwoSum3() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }

    // This is optimizing for add
    // If you want to optimize for find, use another hashset to keep all possible sums.
    public boolean find(int value) {
        for (int num1 : map.keySet()) {
            int num2 = value - num1;
            if (num1 == num2 && map.get(num1) >= 2) {
                return true;
            }
            if (map.containsKey(num2) && map.get(num2) > 0) {
                return true;
            }
        }
        return false;
    }

}
