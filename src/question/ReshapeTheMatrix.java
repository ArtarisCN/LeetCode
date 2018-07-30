package question;

/**
 * question
 * LeetCode
 * 2018.07.30.21:54
 * <p>
 * 566. Reshape the Matrix
 * https://leetcode.com/problems/reshape-the-matrix/description/
 *
 * @author : artaris
 */
class ReshapeTheMatrix {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[][] num = new int[][]{{1, 2}, {3, 4}};

        int[][] result = matrixReshape(num, 2, 4);

        for (int i = 0; i < result.length; i++) {

            for (int j : result[i]) {

                System.out.print(j + " ");
            }

            System.out.println();
        }


        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int height = nums.length, width = nums[0].length;

        if (r * c > height * width) {
            return nums;
        }

        int[][] result = new int[r][c];

        int x = 0, y = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = nums[x][y];

                y++;
                if (y == width) {
                    x++;
                    y = 0;
                }
            }
        }

        return result;

    }
}
