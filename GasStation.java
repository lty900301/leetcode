/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station
 * (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 * 
 * @author JoshLuo
 *         Reference: http://blog.csdn.net/kenden23/article/details/14106137
 * 
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        assert (gas != null && cost != null && gas.length == cost.length);
        int tank = 0, total = 0, prevIndex = -1;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (tank < 0) {
                prevIndex = i;
                tank = 0;
            }
        }
        return total < 0 ? -1 : prevIndex + 1;
    }

}
