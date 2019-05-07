package question;

/**
 * question
 * LeetCode
 * 2019.05.06.18:41
 *
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 * @author : artairs
 */
class SearchA2DMatrixII {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[][] matrix = new int[][]{{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        System.out.println(searchMatrix(matrix, 2));
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 20));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int startLine = 0, endLine = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length - 1] < target) {
                startLine = i;
            }

            if (matrix[i][0] < target) {
                endLine = i + 1;
            }
        }

        endLine = Math.min(endLine,matrix.length - 1);


        for (int i = startLine; i <= endLine; i++) {
            int l = 0, r = matrix[i].length - 1,mid;
            while(l <= r)
            {
                mid = (l + r)/2;
                if(matrix[i][mid] < target) l = mid+1;
                else if(matrix[i][mid] > target) r = mid - 1;
                else return true;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }


}
