package question;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * question
 * LeetCode
 * 2018.10.24.18:27
 *
 * 551. Student Attendance Record I
 * https://leetcode.com/problems/student-attendance-record-i/
 *
 * @author : artairs
 */
class StudentAttendanceRecordI {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(checkRecord("PPALLPA"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean checkRecord(String s) {
        if(s == null || s.length() == 0){
            return true;
        }

        String pattern = ".*L{3,}.*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);

        return s.indexOf("A") == new StringBuilder(s).lastIndexOf("A")
                && !m.matches();
    }

}
