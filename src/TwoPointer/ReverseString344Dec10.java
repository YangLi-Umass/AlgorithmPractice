package TwoPointer;

/**
 * Created by li on 12/10/2016.
 */
public class ReverseString344Dec10 {
    public String reverseStringLaji(String s) {
        if(s.length() == 0) return s;

        //Common case
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--) {
            sb.append(c[i]);
        }
        return sb.toString();
    }

    public String reverseString1(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseString(String s) {
        char[] c = s.toCharArray();
        int l = 0, r = s.length()-1;
        while (l < r) {
            char temp = c[l];
            c[l] = c[r];
            c[r] = temp;
            l++;
            r--;
        }
        return new String(c);
    }
}
