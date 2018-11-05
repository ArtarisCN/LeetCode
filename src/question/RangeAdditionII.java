package question;

/**
 * question
 * LeetCode
 * 2018.11.05.15:27
 *
 * 598. Range Addition II
 * https://leetcode.com/problems/range-addition-ii/
 *
 * @author : artairs
 */
class RangeAdditionII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(maxCount(3,3,new int[][]{{2,2},{3,3}}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int maxCount(int m, int n, int[][] ops) {

        int x = m,y = n;
        for (int i = 0; i < ops.length; i++) {
            if(ops[i][0] > 0){
                x = Math.min(x,ops[i][0]);
            }

            if(ops[i][1] > 0){
                y = Math.min(y,ops[i][1]);
            }
        }

        return x * y;
    }

}
