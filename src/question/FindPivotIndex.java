package question;

/**
 * question
 * LeetCode
 * 2018.11.01.18:40
 * <p>
 * 724. Find Pivot Index
 * https://leetcode-cn.com/problems/find-pivot-index/description/
 *
 * @author : artairs
 */
class FindPivotIndex {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int pivotIndex(int[] nums) {
        int[][] sum = new int[nums.length][2];

        for (int i = nums.length - 1; i >= 0; i--) {
            sum[i][1] = i == nums.length - 1 ? 0 : sum[i + 1][1] + nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            sum[i][0] = i == 0 ? 0 : sum[i - 1][0] + nums[i - 1];
            if (sum[i][0] == sum[i][1]) {
                return i;
            }
        }

        return -1;
    }

}
