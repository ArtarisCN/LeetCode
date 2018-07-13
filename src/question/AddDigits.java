package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午2:48
 * <p>
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/description/
 *
 * @author : rick
 */
class AddDigits {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(addDigits(0)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        return num % 9 == 0 ? 9 : num % 9;
    }

}
