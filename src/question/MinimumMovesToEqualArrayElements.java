package question;

/**
 * question
 * LeetCode
 * 2018.11.06.16:51
 *
 * 453. Minimum Moves to Equal Array Elements
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 *
 * @author : artairs
 */
class MinimumMovesToEqualArrayElements {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(minMoves(new int[]{1,2,3}));
        System.out.println(minMoves(new int[]{1,2}));
        System.out.println(minMoves(new int[]{1,1,2147483647}));
        System.out.println(minMoves(new int[]{-100,0,100}));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int minMoves(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        long sum = 0,min = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            min = Math.min(min,num);
        }

        return (int)(sum - min * nums.length);
    }

}
