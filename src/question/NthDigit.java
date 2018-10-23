package question;

/**
 * question
 * LeetCode
 * 2018.10.23.11:15
 *
 * 400. Nth Digit
 * https://leetcode.com/problems/nth-digit/submissions/
 *
 * @author : artairs
 */
class NthDigit {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findNthDigit(1000000000));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findNthDigit(int n) {
        int index = 1;
        long sum = 0;
        sum += 9 * index;
        while (n > sum) {
            index++;
            sum += 9 * Math.pow(10, index - 1) * index;
        }

        int remainder = (int) (n - (sum - 9 * Math.pow(10, index - 1) * (index))) % index;
        int th = remainder == 0 ? (int) (n - (sum - 9 * Math.pow(10, index - 1) * (index))) / index :
                (int) (n - (sum - 9 * Math.pow(10, index - 1) * (index))) / index + 1;

        int start = (int) Math.pow(10, index - 1);

        th = start + th - 1;
        if (remainder == 0) {
            return th % 10;
        } else {
            return th / (int) Math.pow(10, index - remainder) % 10;
        }
    }


}
