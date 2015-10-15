/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * 
 * You are giving candies to these children subjected to the following requirements:
 * 
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 * @author JoshLuo
 * 
 */
public class Candy {

    public int candy(int[] ratings) {
        assert (ratings != null);
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        // From left to right
        for (int i = 1; i < ratings.length; i++) {
            candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : 1;
        }
        // From right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            candies[i] = ratings[i] > ratings[i + 1] ? Math.max(candies[i], candies[i + 1] + 1) : candies[i];
        }
        // Sum the candy[]
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

}
