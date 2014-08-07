/**
 * Pow(x, n)
 * 
 * Implement pow(x, n).
 * 
 * @author Josh Luo
 * 
 */
public class Pow_x_n {
    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        double half = pow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        if (n > 0)
            return half * half * x;
        return half * half / x;
    }
}
