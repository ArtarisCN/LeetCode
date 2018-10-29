package question;

/**
 * question
 * LeetCode
 * 2018.10.29.09:59
 * <p>
 * 896. Monotonic Array
 * https://leetcode.com/problems/monotonic-array/
 *
 * @author : artairs
 */
class MonotonicArray {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(isMonotonic(new int[]{1, 3, 2}));
        System.out.println(isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(isMonotonic(new int[]{1, 1, 1}));
        System.out.println(isMonotonic(new int[]{1}));
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }

        int last = A[0], status = 0;

        for (int i : A) {
            if (i == last) {
                continue;
            }

            if (i < last) {
                if (status == -1) {
                    return false;
                } else if (status == 0) {
                    status = 1;
                }

                last = i;
                continue;
            }

            if (i > last) {
                if (status == 1) {
                    return false;
                } else if (status == 0) {
                    status = -1;
                }

                last = i;
                continue;
            }
        }

        return true;
    }

}
