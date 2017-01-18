package SortAndSelection;
import java.util.*;
/**
 * Created by li on 12/3/2016.
 */
public class MergeIntervals56Dec3 {
    private static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    /**
     * My first try.
     * */
    public List<Interval> merge1(List<Interval> intervals) {
        List<Interval> list = new LinkedList<>();
        if(intervals.size() == 0) return list;

        Comparator<Interval> c = (i1, i2) -> {
            if(i1.start > i2.start) {
                return 1;
            } else if(i1.start < i2.start) {
                return -1;
            } else {
                if(i1.end > i2.end) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Interval[] a = new Interval[intervals.size()];
        int count = 0;
        for(Interval temp:intervals) {
            a[count] = temp;
            count++;
        }
        Arrays.sort(a,c);

        Interval current = a[0];
        for(Interval temp:a) {
            if(current.end < temp.start) {
                list.add(current);
                current = temp;
            } else {
                current.end = Math.max(current.end, temp.end);
            }
        }
        list.add(current);

        return list;
    }
    /**
     * More elegant solution
     * */

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new LinkedList<>();
        if(intervals.size() == 0) return list;

        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));

        Interval current = intervals.get(0);
        for(Interval temp:intervals) {
            if(current.end < temp.start) {
                list.add(current);
                current = temp;
            } else {
                current.end = Math.max(current.end, temp.end);
            }
        }
        list.add(current);

        return list;
    }
}
