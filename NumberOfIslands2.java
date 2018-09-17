
/**
 * Problem Description:
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns
 * the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after
 * each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example:
 * 
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * 
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 
 * 1 0 0
 * 0 0 0 Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 
 * 1 1 0
 * 0 0 0 Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 
 * 1 1 0
 * 0 0 1 Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 
 * 1 1 0
 * 0 0 1 Number of islands = 3
 * 0 1 0
 * We return the result as an array: [1, 1, 2, 3]
 * 
 * Challenge:
 * Can you do it in time complexity O(k * log(m*n)), where k is the length of the positions?
 */
public class NumberOfIslands2 {

    /**
     * Union Find is an abstract data structure supporting find and unite on disjointed sets of objects, typically used
     * to solve network connectivity problem.
     * @see https://en.wikipedia.org/wiki/Disjoint-set_data_structure
     * @see http://algs4.cs.princeton.edu/15uf/UF.java.html
     * @see http://vancexu.github.io/2015/07/13/intro-to-union-find-data-structure.html
     */
    // public List<Integer> numIslands2(int m, int n, int[][] positions) {
    //
    // }
}
