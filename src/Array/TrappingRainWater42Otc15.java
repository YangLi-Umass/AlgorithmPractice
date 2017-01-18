package Array;

/**
 * Created by li on 10/15/2016.
 */
public class TrappingRainWater42Otc15 {
    public int trap(int[] height) {
        int start = 0, end = height.length - 1;
        int startMax = 0, endMax = 0;
        int res = 0;
        while (start < end) {
            startMax = Math.max(height[start], startMax);
            endMax = Math.max(height[end], endMax);
            if (startMax < endMax) {
                res += (startMax - height[start++]);
            } else {
                res += (endMax - height[end--]);
            }
        }
        return res;
    }
}
