package question;

/**
 * question
 * LeetCode
 * 2019.08.12.17:15
 *
 * @author : artairs
 */
class SetMatrixZeroes {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void setZeroes(int[][] matrix) {

        boolean rowIsZero = false,colIsZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                colIsZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0){
                rowIsZero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //col
        for (int i = 1; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        //row
        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for (int j = 0; j < matrix[1].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowIsZero){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(colIsZero){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    private static boolean checkRowZero(int[][] matrix, int row, int start) {
        for (int i = start; i < matrix[row].length; i++) {
            if (matrix[row][i] == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkColZero(int[][] matrix, int col, int start) {
        for (int i = start; i < matrix.length; i++) {
            if (matrix[i][col] == 0) {
                return false;
            }
        }
        return true;
    }


}
