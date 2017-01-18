package TwoPointer;

import java.util.HashMap;

/**
 * Created by li on 12/10/2016.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring1(String s) {

        if(s.length() == 0) return 0;
        char[] c = s.toCharArray();
        int left=0,right=0;
        int maxL = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = left; j <= right ; j++) {
                if(c[i] == c[j]) {
                    left = j+1;
                }
            }
            right = right+1;
            int l = right-left+1;
            maxL = Math.max(maxL, l);
        }
        return maxL;

    }

    /**
     * Dec 10
     * 54ms 60%
     *
     *
     * */

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> m = new HashMap<>();
        int max = 0;
        for(int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if(m.containsKey(c)) {
                l = Math.max(l, m.get(c)+1);
            }

            m.put(c, r);
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
