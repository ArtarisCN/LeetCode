package question;

/**
 * question
 * LeetCode
 * 2019.02.20.17:53
 * <p>
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 *
 * @author : artairs
 */
class RotateImage {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        int[][] matrix = new int[][]{{1,2,3},
//                {4,5,6},
//                {7,8,9}};

//        int[][] matrix = new int[][]{{1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//                {16,17,18,19,20},
//                {21,22,23,24,25}};

//        int[][] matrix = new int[][]{{1}};
        int[][] matrix = new int[][]{{}};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        rotate(matrix);


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

//        rotate(new int[][]{{5, 1, 9, 11},
//                {2, 4, 8, 10},
//                {13, 3, 6, 7},
//                {15, 14, 12, 16}});


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void rotate(int[][] matrix) {
        rotateHelper(matrix, 0);
    }

    public static void rotateHelper(int[][] matrix, int value) {
        int length = matrix.length - value * 2;
        for (int i = value; i < length + value - 1; i++) {
            int ex = matrix[i][matrix.length - value - 1];
            matrix[i][matrix.length - value - 1] = matrix[value][i];

            int temp = matrix[matrix.length - value - 1][matrix.length - i - 1];
            matrix[matrix.length - value - 1][matrix.length - i - 1] = ex;
            ex = temp;

            temp = matrix[matrix.length - i - 1][value];
            matrix[matrix.length - i - 1][value] = ex;
            ex = temp;

            matrix[value][i] = ex;
        }

        value++;
        if (value < (matrix.length + 1) / 2) {
            rotateHelper(matrix, value);
        }
    }


}
