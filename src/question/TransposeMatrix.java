package question;

/**
 * question
 * LeetCode
 * 2018.07.27.下午2:05
 *
 * 867. Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/description/
 *
 * @author : rick
 */
class TransposeMatrix {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public int[][] transpose(int[][] A) {

        int[][] result = new int[A[0].length][A.length];


        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = A[j][i];
            }
        }

        return result;

    }

}
