package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午1:55
 *
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 *
 * @author : rick
 */
class RotateArray {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[] nums = new int[]{1,2,3,4,5,6,7};

        rotate(nums,3);

        for (int num : nums) {
            System.out.print(String.valueOf(num) + " ");
        }


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static void rotate(int[] nums, int k) {

        int[] result = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int to = (i + k) % nums.length;

            nums[to] = result[i];
        }
    }
}
