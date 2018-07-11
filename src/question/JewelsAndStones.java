package question;

/**
 * question
 * LeetCode
 * 2018.07.10.下午6:40
 * <p>
 * 771. Jewels and Stones
 * https://leetcode.com/problems/jewels-and-stones/description/
 *
 * @author : rick
 */
class JewelsAndStones {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(numJewelsInStones("aA", "aAAbbbb"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int numJewelsInStones(String J, String S) {

        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }

        int count = 0;

        char[] stones = S.toCharArray();

        for (char c : J.toCharArray()) {

            for (char stone : stones) {
                if (stone == c) {
                    count++;
                }
            }
        }

        return count;

    }
}
