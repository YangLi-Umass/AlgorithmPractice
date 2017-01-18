package Math;

/**
 * Created by li on 12/9/2016.
 */
public class Pow50Dec9 {

    /**
     * Recursion
     * 需要handle n=Integer.MIN_VALUE的情况
     *
     * */
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == Integer.MIN_VALUE) return myPow(x*x, n/2);
        if(n < 0) {
            x = 1/x;
            n = -n;
        }

        return (n%2 == 0) ? myPow(x*x,n/2) : x*myPow(x*x,n/2);
    }

    /**
     * Iteration
     * 注意result的类型是double
     * 注意1/0会不会发生
     *
     * */
    public double myPow2(double x, int n) {
        double result = 1;
        if (n == 0) return result;
        long num;
        if(n < 0) {num = -(long)n; x = 1/x;}
        else num = (long)n;
        while (num != 0) {
            if((num & 1) == 1) result *= x;
            num = num >> 1;
            x *= x;
        }
        return result;
    }
}
