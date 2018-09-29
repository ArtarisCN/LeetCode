package question;

/**
 * question
 * LeetCode
 * 2018.09.29.16:10
 *
 * 860. Lemonade Change
 * https://leetcode.com/problems/lemonade-change/description/
 *
 * @author : artairs
 */
class LemonadeChange {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(lemonadeChange(new int[]{5,5,5,10,20}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean lemonadeChange(int[] bills) {
        int[] invoice = new int[2];

        for (int bill : bills) {
            if(bill == 5){
                invoice[0] ++;
            } else if(bill == 10){
                if(invoice[0] > 0){
                    invoice[0] --;
                    invoice[1] ++;
                } else {
                    return false;
                }
            } else if(bill == 20){
                if(invoice[1] > 0 && invoice[0] > 0){
                    invoice[0] --;
                    invoice[1] --;
                } else if(invoice[0] > 3){
                    invoice[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
