package question;

/**
 * question
 * LeetCode
 * 2019.04.01.17:19
 *
 * 885. Spiral Matrix III
 * https://leetcode.com/problems/spiral-matrix-iii/
 *
 * @author : artairs
 */
class SpiralMatrixIII {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        for (int[] ints : spiralMatrixIII(5, 6, 1, 4)) {
//            System.out.println(ints[0] + " " + ints[1]);
//        }


        for (int[] ints : spiralMatrixIII(1, 4, 0, 0)) {
            System.out.println(ints[0] + " " + ints[1]);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int height = Math.max(Math.abs(R - r0 - 1), r0) * 2, width = Math.max(Math.abs(C - c0 - 1), c0) * 2;
        int dx = height / 2 - r0, dy = width / 2 - c0;
        int[][] result = new int[(R) * (C)][2];
        int index = 0;
        result[index][0] = r0;
        result[index][1] = c0;
        index++;
        for (int circle = 1; circle < Math.max(width / 2, height / 2) + 1; circle++) {
            for (int length = 0; length < circle * 2; length++) {

                int x = height / 2 - circle + 1 + length - dx;
                int y = width / 2 + circle - dy;

                if (valid(R, C, x, y)) {
                    result[index][0] = x;
                    result[index][1] = y;
                    index++;
                }
            }

            for (int length = 0; length < circle * 2; length++) {

                int x = height / 2 + circle - dx;
                int y = width / 2 + circle - 1 - length - dy;

                if (valid(R, C, x, y)) {
                    result[index][0] = x;
                    result[index][1] = y;
                    index++;
                }
            }

            for (int length = 0; length < circle * 2; length++) {

                int x = height / 2 + circle  - 1 - length - dx;
                int y = width / 2 - circle - dy;

                if (valid(R, C, x, y)) {
                    result[index][0] = x;
                    result[index][1] = y;
                    index++;
                }

            }


            for (int length = 0; length < circle * 2; length++) {

                int x = height / 2 - circle - dx;
                int y = width / 2 - circle + 1 + length - dy   ;

                if (valid(R, C, x, y)) {
                    result[index][0] = x;
                    result[index][1] = y;
                    index++;
                }

            }
        }

        return result;
    }

    private static boolean valid(int R, int C, int x, int y) {
        return x >= 0 &&
                x < R &&
                y >= 0 &&
                y < C;
    }

}
