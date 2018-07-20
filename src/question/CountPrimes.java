package question;

/**
 * question
 * LeetCode
 * 2018.07.20.下午3:47
 * <p>
 * 204. Count Primes
 * https://leetcode.com/problems/count-primes/description/
 *
 * @author : rick
 */
class CountPrimes {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(countPrimes(10));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int countPrimes(int n) {

        boolean[] mark = new boolean[n + 1];

        int result = 0;

        int i = 0;
        for (i = 2; i <  (int)Math.sqrt(n) + 1; i++) {
            if(mark[i + 1]){
                continue;
            }

            System.out.println(i);
            result ++;

            for (int j = i + 1; j <  mark.length; j++) {
                if(mark[j + 1]){
                    continue;
                }

                if(j % i == 0){
                    mark[j] = true;
                }
            }
        }

        for (int j = i + 1; j <  n; j++) {
            if(!mark[ j + 1]) {

                System.out.println(j);
                result++;
            }
        }

        return result;

    }
}
