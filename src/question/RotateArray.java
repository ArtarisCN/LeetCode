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

        int[] nums = new int[]{1,2,3,4,5,6,7,8};

        rotate(nums,2);

        for (int num : nums) {
            System.out.print(String.valueOf(num) + " ");
        }

        System.out.println();

        int[] nums1 = new int[]{1,2,3,4,5,6,7,8};

        rotate1(nums1,2);

        for (int num : nums1) {
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

    public static void rotate1(int[] nums, int k) {
        int ex = nums[0], x = 0;

        for (int i = 0; i < nums.length; i++) {
            nums[(x + k) % nums.length] += ex;
            ex = nums[(x + k) % nums.length] - ex;
            nums[(x + k) % nums.length] = nums[(x + k) % nums.length] - ex;

            x = (x + k) % nums.length;
        }
    }
}