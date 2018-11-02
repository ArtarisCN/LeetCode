package question;

/**
 * question
 * LeetCode
 * 2018.11.02.10:24
 *
 * 414. Third Maximum Number
 * https://leetcode.com/problems/third-maximum-number/
 *
 * @author : artairs
 */
class ThirdMaximumNumber {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(thirdMax(new int[]{3, 2, 1}));
        System.out.println(thirdMax(new int[]{1, 2}));
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax(new int[]{1,2,-2147483648}));
        System.out.println(thirdMax(new int[]{1,2,2,5,3,5}));
        System.out.println(thirdMax(new int[]{-2147483648,-2147483648,-2147483648,-2147483648,1,1,1}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int thirdMax(int[] nums) {
        int maxV = Integer.MIN_VALUE,secondV = Integer.MIN_VALUE,thirdV  = Integer.MIN_VALUE,exchange = 0;
        for (int num : nums) {
            if(num > maxV){
                exchange ++;
                thirdV = secondV;
                secondV = maxV;
                maxV = num;
            } else if(num == maxV){
                exchange = Math.max(1,exchange);
            } else if(num > secondV){
                exchange ++;
                thirdV = secondV;
                secondV = num;
            } else if(num ==  secondV){
                exchange = Math.max(2,exchange);
            } else if(num > thirdV){
                exchange ++;
                thirdV = num;
            } else if(num == thirdV){
                exchange = Math.max(3,exchange);
            }
        }

        if(exchange >= 3) {
            return thirdV;
        } else {
            return maxV;
        }
    }

}
