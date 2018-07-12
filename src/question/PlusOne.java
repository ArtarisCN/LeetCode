package question;

/**
 * question
 * LeetCode
 * 2018.07.12.下午6:04
 *
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/description/
 *
 * @author : rick
 */
class PlusOne {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int[] digits = new int[]{9,9,9,9};

        for (int i : plusOne(digits)) {
            System.out.print(String.valueOf(i) + " ");
        }


        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] plusOne(int[] digits) {

        if(digits.length < 1){
            return digits;
        }

        int plus = 1;

        for (int i = digits.length - 1; i >= 0; i--) {

            int val = digits[i] + plus;

            digits[i] = val % 10;

            plus = val / 10;

            if(plus == 0){
                break;
            }
        }


        if(plus == 1){

            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, result.length - 1);
            return result;
        }

        return digits;


    }
}
