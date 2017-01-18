package Array;

/**
 * Created by li on 12/21/2016.
 */
public class ZigZagConversion6Dec21 {

    public static String convert1(String s, int numRows) {
        if(numRows == 0 || numRows == 1) return s;
        if(s.length() <= numRows) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char[] c = s.toCharArray();
        int step = (numRows-1)*2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j+=step) {
                sb.append(c[j]);
                if(i != 0 && i != numRows-1 && j+step-2*i<len) {
                    sb.append(c[j+step-2*i]);
                }
            }
        }

        return sb.toString();
    }
    /**
     * Dec 21
     *
     * */
    public static String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows <= 1) return s;
        int interval = (numRows - 1)*2;
        StringBuilder sb = new StringBuilder();
        int j;
        for(int i = 0; i < numRows; i++) {
            j = i;
            while(j < s.length()){
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows-1 && j+interval-2*i < s.length()) {
                    sb.append(s.charAt(j+interval-2*i));
                }
                j += interval;
            }
        }
        return sb.toString();
    }
}
