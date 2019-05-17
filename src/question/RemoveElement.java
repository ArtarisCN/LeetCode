package question;

/**
 * question
 * LeetCode
 * 2018.07.12.0:45
 * <p>
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/description/
 *
 * @author : artaris
 */
class RemoveElement {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] nums = new int[]{3,1};

        System.out.println(String.valueOf(removeElement(nums, 3)));

        for (int num : nums) {
            System.out.print(String.valueOf(num) + " ");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int removeElement(int[] nums, int val) {

        if (nums.length == 0) {
            return 0;
        }

        int ex, count = nums.length - 1;

        for (int i = 0; i < nums.length && count > i; i++) {
            while (nums[count] == val && count > 0) {
                count--;
            }

            if (count < i) {
                break;
            }

            if (nums[i] == val) {
                ex = nums[count];
                nums[count] = nums[i];
                nums[i] = ex;
            }


            while (nums[count] == val && count > 0) {
                count--;
            }
        }

        if(count == 0){
            if(nums[0] == val){
                return 0;
            }

        }

        return count + 1;
    }
}
