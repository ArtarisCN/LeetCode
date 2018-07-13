package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午2:11
 * <p>
 * 171. Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 *
 * @author : rick
 */
class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(String.valueOf(titleToNumber("ZY")));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int titleToNumber(String s) {

        int decimal = 26;

        char[] chars = s.toCharArray();

        int result = 0;

        for (int i = chars.length - 1; i >= 0; i--) {

            result += Math.pow(decimal, chars.length - i - 1) * (chars[i] - 'A' + 1);

        }

        return result;
    }

}
