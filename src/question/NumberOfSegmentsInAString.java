package question;

/**
 * question
 * LeetCode
 * 2018.11.06.14:44
 *
 * 434. Number of Segments in a String
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 *
 * @author : artairs
 */
class NumberOfSegmentsInAString {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(countSegments("    "));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int countSegments(String s) {
        if(s.length() == 0 || s.trim().length() == 0){
            return 0;
        }

        String[] sp = s.trim().split(" +");

        return sp.length;
    }

}
