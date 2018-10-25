package question;

/**
 * question
 * LeetCode
 * 2018.10.25.18:02
 *
 * 908. Smallest Range I
 * https://leetcode.com/problems/smallest-range-i/
 *
 * @author : artairs
 */
class SmallestRangeI {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(smallestRangeI(new int[]{1},0));
        System.out.println(smallestRangeI(new int[]{0,10},2));
        System.out.println(smallestRangeI(new int[]{1,3,6},3));
        System.out.println(smallestRangeI(new int[]{1,3,9},3));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int smallestRangeI(int[] A, int K) {
        int max = 0,min = 10000;
        for (int i : A) {
            if(min > i){
                min = i;
            }

            if(max < i){
                max = i;
            }
        }

        return Math.max(0,max - min - 2 * K);
    }
}
