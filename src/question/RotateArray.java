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

        rotate1(nums,2);

        for (int num : nums) {
            System.out.print(String.valueOf(num) + " ");
        }

        System.out.println();

        int[] nums1 = new int[]{1,2,3,4,5,6,7};

        rotate1(nums1,3);

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
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            if (nums.length - 1 >= 0)
                System.arraycopy(nums, 0, nums, 1, nums.length - 1);
            nums[0] = last;
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (k>nums.length) {
            k = k % nums.length;
        }
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start<end) {
            int tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;end--;
        }
    }

}