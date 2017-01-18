package BreadthFirstSearch;

/**
 * Created by li on 11/15/2016.
 */
public class PerfectSquares279 {
    public int[] dp;
    public int numSquares(int n) {
        if(n <= 3) return n;
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;


        for(int i = 4; i <= n; i++) {

            if(i == (int)Math.sqrt(i)* (int)Math.sqrt(i)) {
                dp[i] = 1;
            } else {
                int r = i;
                for(int j = (int)Math.sqrt(i); j >= 2; j--) {
                    r = Math.min(r, dp[j*j] + dp[i-j*j]);
                }
                dp[i] = r;
            }

        }
        return dp[n];
    }
}
