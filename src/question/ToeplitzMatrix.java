package question;

/**
 * question
 * LeetCode
 * 2018.07.30.下午6:19
 * <p>
 * 766. Toeplitz Matrix
 * https://leetcode.com/problems/toeplitz-matrix/description/
 *
 * @author : rick
 */
class ToeplitzMatrix {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        int[][] matrix = new int[][]{{36,59,71,15,26,82,87},
                                     {56,36,59,71,15,26,82},
                                     {15,0,36,59,71,15,26}};

        System.out.println(isToeplitzMatrix(matrix));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {

        int vertical = 0, horizontal = 0;
        for (int i = 0; i < matrix[0].length; i++) {

            int value = matrix[vertical][horizontal];

            while (vertical <= matrix.length - 1 && horizontal <= matrix[0].length - 1) {

                if (value != matrix[vertical][horizontal]) {
                    return false;
                }

                vertical++;
                horizontal++;

            }

            vertical = 0;
            horizontal = i;

        }

        vertical = 1;
        horizontal = 0;

        if (matrix.length == 1) {
            return true;
        }

        for (int i = 0; i < matrix.length; i++) {

            int value = matrix[vertical][horizontal];
            while (vertical < matrix.length - 1 && horizontal < matrix[0].length - 1) {

                if (value != matrix[vertical][horizontal]) {
                    return false;
                }

                vertical++;
                horizontal++;

            }

            vertical = i;
            horizontal = 0;
        }

        return true;
    }


    public boolean isToeplitzMatrixMAX(int[][] matrix) {

        for (int i = 1; i < matrix.length; i++) {
            int j=1;
            for (; j < i && j < matrix[0].length; j++) {
                if(matrix[i][j]!=matrix[i-j][0]) return false;
            }
            for (;j < matrix[0].length; j++) {
                if(matrix[i][j]!=matrix[0][j-i]) return false;
            }
        }
        return true;
    }

}
