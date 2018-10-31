package question;

/**
 * question
 * LeetCode
 * 2018.10.31.13:59
 * <p>
 * 661. Image Smoother
 * https://leetcode.com/problems/image-smoother/
 *
 * @author : artairs
 */
class ImageSmoother {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[][] result = imageSmoother(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int sum = M[i][j], count = 1;
                if (i != 0) {
                    sum += M[i - 1][j];
                    count++;
                    if (j != 0) {
                        sum += M[i - 1][j - 1];
                        count++;
                    }

                    if (j != M[i].length - 1) {
                        sum += M[i - 1][j + 1];
                        count++;
                    }
                }

                if (i != M.length - 1) {
                    sum += M[i + 1][j];
                    count++;
                    if (j != 0) {
                        sum += M[i + 1][j - 1];
                        count++;
                    }

                    if (j != M[i].length - 1) {
                        sum += M[i + 1][j + 1];
                        count++;
                    }
                }

                if (j != 0) {
                    sum += M[i][j - 1];
                    count++;
                }

                if (j != M[i].length - 1) {
                    sum += M[i][j + 1];
                    count++;
                }

                result[i][j] = sum / count;
            }
        }
        return result;
    }

}
