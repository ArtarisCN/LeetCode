package question;

/**
 * question
 * LeetCode
 * 2018.07.12.1:11
 * <p>
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * @author : artaris
 */
class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] nums = new int[]{1, 2, 3, 4, 5};

        System.out.println(String.valueOf(removeDuplicates(nums)));

        for (int num : nums) {
            System.out.print(String.valueOf(num) + " ");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1)
            return 1;

        if (nums.length == 2)
            return nums[0] == nums[1] ? 1 : 2;

        int index;
        for (index = 0; index < nums.length - 1; ) {
            if (nums[index] < nums[index + 1]) {
                index++;
                continue;
            }

            if (nums[index] == nums[index + 1]) {
                boolean find = false;
                for (int i = index + 2; i <= nums.length - 1; i++) {
                    if (nums[i] > nums[index + 1]) {
                        find = true;
                        nums[i] += nums[index + 1];
                        nums[index + 1] = nums[i] - nums[index + 1];
                        nums[i] = nums[i] - nums[index + 1];
                        index++;
                        break;
                    }
                }
                if (find) {
                    continue;
                } else {
                    break;
                }
            }

            if (nums[index] > nums[index + 1]) {
                boolean find = false;
                for (int i = index + 2; i <= nums.length - 1; i++) {
                    if (nums[i] > nums[index]) {
                        find = true;
                        nums[i] += nums[index + 1];
                        nums[index + 1] = nums[i] - nums[index + 1];
                        nums[i] = nums[i] - nums[index + 1];
                        index++;
                        break;
                    }
                }
                if (find) {
                    continue;
                } else {
                    break;
                }
            }
        }

        return index + 1;
    }


}
