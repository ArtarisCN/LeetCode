package question;

/**
 * question
 * LeetCode
 * 2018.11.02.11:45
 *
 * 686. Repeated String Match
 * https://leetcode.com/problems/repeated-string-match/
 *
 * @author : artairs
 */
class RepeatedStringMatch {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(repeatedStringMatch("a","aaab"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (i < 10000){
            if(sb.append(A).toString().contains(B)){
                return i;
            }

            if(sb.toString().length() > B.length() * 2 && sb.toString().length() > A.length() * 2){
                break;
            }
            i++;
        }

        return -1;
    }

}
