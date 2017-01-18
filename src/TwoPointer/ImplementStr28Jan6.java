package TwoPointer;

/**
 * Created by li on 1/6/2017.
 */
public class ImplementStr28Jan6 {
    /**
     * My solution
     * Looks complicated
     *
     * */
    public int strStr1(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length(); i++) {
            if(i+needle.length()-1 >= haystack.length()) break;
            int m = i, n = 0;
            while(m < haystack.length() && n < needle.length()){
                if(haystack.charAt(m) == needle.charAt(n)){
                    m++;
                    n++;
                } else {
                    break;
                }
            }
            if(n == needle.length())return i;
        }
        return -1;
    }

    /**
     *
     * more beautiful
     * */
    public int strStr(String haystack, String needle) {
        for(int i = 0; ; i++){
            for(int j = 0; ; j++){
                if(j == needle.length()) return i;
                if(i+needle.length() > haystack.length()) return -1;
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
        }

    }
}
