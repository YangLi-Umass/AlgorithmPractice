package Math;

import java.util.HashMap;

/**
 * Created by li on 1/6/2017.
 */
public class MaxPointsOnALine149Jan6 {
    private static class Point {
        int x;
        int y;
        Point() {x = 0; y = 0;}
        Point(int a, int b) {x = a; y = b;}
    }


    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length <= 2) return points.length;

        HashMap<Double,Integer> map = new HashMap<>();
        int sameX = 0, samePoint = 1, max = 0;
        int result = 0;
        for(int i = 0; i < points.length-1; i++) {
            map.clear();
            sameX = 0;
            samePoint = 1;
            max = 0;
            for(int j = i+1; j < points.length; j++) {
                if(points[i].x == points[j].x) {
                    if(points[i].y == points[j].y) samePoint++;
                    else sameX++;
                    continue;
                }
                double s;
                if(points[i].y == points[j].y) s = 0;
                else s= (double)(points[i].y - points[j].y)/(points[i].x - points[j].x);

                if(!map.containsKey(s)) map.put(s,0);
                map.put(s,map.get(s)+1);
                max = Math.max(max, map.get(s));
            }

            result = Math.max(result, Math.max(max,sameX)+samePoint);
        }
        return result;
    }
}
