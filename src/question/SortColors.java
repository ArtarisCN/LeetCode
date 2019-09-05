package question;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2019.09.04.20:48
 *
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 * @author : artairs
 */
class SortColors {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        int[] num = new int[]{2, 0, 2, 1, 1, 0};
//        int[] num = new int[]{1, 2, 1};
        int[] num = new int[]{0, 0, 1, 0, 1, 1};


        sortColors2(num);
        PrintUtils.printf(num);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void sortColors2(int[] nums) {
        int[] times = new int[3];
        for (int num : nums) {
            times[num]++;
        }
        int index = 0;
        for (int i = 0; i < times.length; i++) {
            while (times[i] > 0) {
                nums[index] = i;
                times[i] --;
                index++;
            }
        }
    }

    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        tag:while (left < right) {
                while (left < nums.length && nums[left] == 0) {
                    left++;
                }
                while (right > 0 && nums[right] == 2) {
                    right--;
                }
                if (right < 0 || left >= nums.length || left >= right) {
                    break;
                }
                if (nums[left] > nums[right]) {
                    swopNum(nums, left, right);
                } else if (nums[left] == nums[right]) {
                    int current = left + 1;
                    while (current < right) {
                        if (nums[current] < nums[left]) {
                            swopNum(nums, left, current);
                            continue tag;
                        } else if (nums[right] < nums[current]) {
                            swopNum(nums, current, right);
                            continue tag;
                        }
                        current++;
                    }
                    return;
                }
        }
    }

    private static void swopNum(int[] nums, int i, int j) {
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[j] = nums[i] - nums[j];
    }
}
