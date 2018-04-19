package question;

/**
 * question
 * LeetCode
 * 2018.04.19.下午4:32
 * <p>
 * 136. Single Number
 * https://leetcode.com/problems/single-number/description/
 *
 * @author : rick
 */
class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 1, Integer.MAX_VALUE, 2, 2, 4, 5, 6, 5, 4, 6}));
    }


    public static int singleNumber(int[] nums) {
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
            v ^= nums[i];
        }
        return v;
    }
}
