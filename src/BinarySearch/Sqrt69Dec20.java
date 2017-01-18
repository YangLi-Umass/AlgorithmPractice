package BinarySearch;

/**
 * Created by li on 12/20/2016.
 */
public class Sqrt69Dec20 {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int l = 0, r = x;
        int mid;
        while(l < r) {
            mid = (l+r)/2;
            if(x/mid < mid) {
                r = mid-1;
            } else {
                if(x/(mid+1) < (mid+1)) {
                    return mid;
                }
                l = mid+1;
            }
        }
        return l;
    }
}
