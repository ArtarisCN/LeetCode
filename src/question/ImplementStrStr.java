package question;

/**
 * question
 * LeetCode
 * 2018.07.13.上午11:17
 *
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * @author : rick
 */
class ImplementStrStr {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(String.valueOf(strStr("","bba")));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }

        if(!haystack.contains(needle)){
            return -1;
        }

        return haystack.indexOf(needle);
    }
}
