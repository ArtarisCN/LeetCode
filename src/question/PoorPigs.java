package question;

/**
 * question
 * LeetCode
 * 2018.10.30.15:34
 *
 * 458. Poor Pigs
 * https://leetcode.com/problems/poor-pigs/
 *
 * @author : artairs
 */
class PoorPigs {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(poorPigs(8,10,10));

        System.out.println(Math.log(250)/Math.log(2));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)(Math.log((int)(buckets/((int)(minutesToTest/minutesToDie))))/Math.log(2));
    }

}
