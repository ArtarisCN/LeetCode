package question;

/**
 * question
 * LeetCode
 * 2018.07.19.下午4:48
 *
 * 476. Number Complement
 * https://leetcode.com/problems/number-complement/description/
 *
 * @author : rick
 */
class NumberComplement {

    public static void main(String[] args) {


        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findComplement(8));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findComplement(int num) {

        int length = (int)(Math.log(num)/Math.log(2));

        int x = (int) (Math.pow(2,length + 1) - 1);

        return num^x;
    }

    public static int findComplement2(int num) {

        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }

}
