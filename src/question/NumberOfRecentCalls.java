package question;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * question
 * LeetCode
 * 2018.11.12.11:36
 *
 * 933. Number of Recent Calls
 * https://leetcode.com/problems/number-of-recent-calls/
 *
 * @author : artairs
 */
class NumberOfRecentCalls {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        RecentCounter obj = new RecentCounter();
//        System.out.println(obj.ping(0));
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    static class RecentCounter {

        Queue<Integer> nodes = new ArrayBlockingQueue<>(3000);

        public RecentCounter() {

        }

        public int ping(int t) {
            nodes.offer(t);
            while (nodes.size() > 0 && Math.abs(nodes.element() - t) > 3000) {
                nodes.poll();
            }

            return nodes.size();
        }

    }

}
