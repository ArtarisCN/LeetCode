package question;

/**
 * question
 * LeetCode
 * 2018.07.12.1:11
 *
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * @author : artaris
 */
class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] nums = new int[]{1,1,2,2,4};

        System.out.println(String.valueOf(removeDuplicates(nums)));

        for (int num : nums) {
            System.out.print(String.valueOf(num) + " ");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int ex, count = nums.length - 1;

        for (int i = 0; i < nums.length && count > i; i++) {

            if(nums[i] >= nums[i + 1]){

                ex = nums[i + 2];
                nums[i + 2] = nums[i + 1];
                nums[i + 1] = ex;

                i--;
            }
        }



        return count + 1;


    }


}
