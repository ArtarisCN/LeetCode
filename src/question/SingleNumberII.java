package question;

/**
 * question
 * LeetCode
 * 2018.04.19.下午4:46
 * <p>
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/description/
 *
 * @author : rick
 */
class SingleNumberII {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{-401451, -177656, -2147483646, -473874, -814645, -2147483646, -852036, -457533, -401451, -473874, -401451, -216555, -917279, -457533, -852036, -457533, -177656, -2147483646, -177656, -917279, -473874, -852036, -917279, -216555, -814645, 2147483645, -2147483648, 2147483645, -814645, 2147483645, -216555}));
    }

    public static int singleNumber(int[] nums) {
        int[] resultPositive = new int[32];
        int[] resultNegative = new int[32];

        for (int i = 0; i < nums.length; i++) {

            boolean flag = nums[i] > 0;

            String value = Integer.toBinaryString(Math.abs(nums[i]));
            for (int j = value.length() - 1; j >= 0; j--) {
                int v = value.charAt(j) - 48;

                if (flag) {
                    resultPositive[value.length() - j - 1] += v;
                } else {
                    resultNegative[value.length() - j - 1] -= v;
                }
            }
        }


        boolean start = false;
        String resultStringPositive = "", resultStringNegative = "";
        for (int i = resultPositive.length - 1; i >= 0; i--) {
            if (!start) {
                if (resultPositive[i] == 0) {
                    continue;
                } else {
                    start = true;
                }
            }

            resultStringPositive += Math.abs(resultPositive[i] % 3);
        }

        start = false;
        for (int i = resultNegative.length - 1; i >= 0; i--) {
            if (!start) {
                if (resultNegative[i] == 0) {
                    continue;
                } else {
                    start = true;
                }
            }

            resultStringNegative += Math.abs(resultNegative[i] % 3);
        }

        if ("10000000000000000000000000000000".equals(resultStringNegative)) {
            return -Integer.MAX_VALUE - 1;
        }

        return Integer.valueOf(resultStringPositive, 2) - Integer.valueOf(resultStringNegative, 2);
    }


    int singleNumber(int A[], int n) {
        int one = 0, two = 0;
        for (int i = 0; i < n; i++) {
            two |= A[i] & one;
            one ^= A[i];
            int three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
