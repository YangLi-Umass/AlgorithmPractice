package Math;

/**
 * Created by li on 1/13/2017.
 */
public class CountPrimes204Jan13 {

    /**
     * 先假定2到n-1都是prime，然后找到不是的往下减
     *
     * */
    public int countPrimes(int n) {
        if(n < 2) return 0;
        int count = n-2;
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i*i <= n-1; i++) {
            if(notPrime[i]) continue;
            for(int j = i*i; j <= n-1; j+=i) {
                if(!notPrime[j]) {
                    count--;
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }
}
