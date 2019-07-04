package question;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Interval;


/**
 * question
 * LeetCode
 * 2019.04.03.17:55
 * <p>
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * @author : artairs
 */
class MergeIntervals {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<Interval> intervals = new ArrayList<>();
//        intervals.isPoped(new Interval(1,3));
//        intervals.isPoped(new Interval(2,6));
//        intervals.isPoped(new Interval(8,10));
//        intervals.isPoped(new Interval(15,18));

        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(5, 5));

        for (Interval interval : merge(intervals)) {
            System.out.println(interval);
        }


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0){
            return intervals;
        }

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new ArrayList<>();

        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval compare = intervals.get(i);

            if (compare.start <= current.end ) {
                current = new Interval(current.start, Math.max(compare.end,current.end));
            } else {
                result.add(current);
                current = compare;
            }
        }

        result.add(current);
        return result;
    }

}
