package question;

/**
 * question
 * LeetCode
 * 2018.07.27.上午11:28
 * <p>
 * 852. Peak Index in a Mountain Array
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 *
 * @author : rick
 */
class PeakIndexInAMountainArray {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();



        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int peakIndexInMountainArray(int[] A) {
        if (A.length <= 1) {
            return 0;
        }

        int index = 0;
        int peak = A[0];

        for (int i = 0; i < A.length; i++) {
            if (A[i] > peak) {
                peak = A[i];
                index = i;
            }
        }

        return index;

    }
}
