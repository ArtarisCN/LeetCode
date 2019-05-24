package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午3:39
 * <p>
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * @author : rick
 */
class MoveZeroes {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[] nums = new int[]{0,0};

        moveZeroes2(nums);

        for (int num : nums) {
            System.out.print(String.valueOf(num) + " ");
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void moveZeroes(int[] nums) {

        int currentZ, currentN;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currentZ = findZero(nums, i);
                currentN = findNum(nums, i);

                if (currentN == -1 || currentZ == -1 || currentN == nums.length || currentZ == nums.length) {
                    return;
                }


                int temp = nums[currentZ];
                nums[currentZ] = nums[currentN];
                nums[currentN] = temp;
            }
        }
    }

    public static int findZero(int[] nums, int index) {
        if (nums[index] == 0) {
            return index;
        }

        int result = index;
        while (result < nums.length && nums[result] != 0) {
            result++;
        }
        return result == index ? -1 : result;
    }

    public static int findNum(int[] nums, int index) {
        if (nums[index] != 0) {
            return index;
        }

        int result = index;
        while (result < nums.length && nums[result] == 0) {
            result++;
        }
        return result == index ? -1 : result;
    }


    public static void moveZeroes2(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
