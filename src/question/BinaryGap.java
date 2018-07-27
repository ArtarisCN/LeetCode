package question;

/**
 * question
 * LeetCode
 * 2018.07.27.下午4:33
 * <p>
 * 868. Binary Gap
 * https://leetcode.com/problems/binary-gap/description/
 *
 * @author : rick
 */
class BinaryGap {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(binaryGap(8));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int binaryGap(int N) {
        int maxGap = 0;

        int appear = -1;
        int count = 1;

        while (N > 0) {
            if (N % 2 == 1) {

                if (appear == -1) {
                    appear = count;
                } else {
                    if (maxGap < (count - appear)) {
                        maxGap = count - appear;
                    }
                    appear = count;
                }
            }
            count++;
            N = N >> 1;
        }

        return maxGap;
    }
}
