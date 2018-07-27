package question;

/**
 * question
 * LeetCode
 * 2018.07.27.下午2:45
 * <p>
 * 806. Number of Lines To Write String
 * https://leetcode.com/problems/number-of-lines-to-write-string/description/
 *
 * @author : rick
 */
class NumberOfLinesToWriteString {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        for (int i : numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz")) {
            System.out.println(i);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int[] numberOfLines(int[] widths, String S) {

        int lines = 1;
        int maxLength = 100;

        int currentLength = maxLength;

        for (int i = 0; i < S.length(); i++) {
            if (currentLength >= (widths[S.charAt(i) - 'a'])) {
                currentLength -= (widths[S.charAt(i) - 'a']);
            } else {
                lines++;
                currentLength = maxLength - (widths[S.charAt(i) - 'a']);
            }
        }

        return new int[]{lines,maxLength - currentLength};
    }
}
