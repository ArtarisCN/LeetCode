package question;

/**
 * question
 * LeetCode
 * 2018.07.27.上午11:08
 *
 * 461. Hamming Distance
 * https://leetcode.com/problems/hamming-distance/description/
 *
 * @author : rick
 */
class HammingDistance {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(hammingDistance(0,7));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int hammingDistance(int x, int y) {
        int distance = x^y;

        int result = 0;


        while (distance != 0){
            if(distance % 2 == 1){
                result ++;
            }

            distance/=2;
        }

        return result;
    }
}
