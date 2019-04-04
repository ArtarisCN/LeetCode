package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2019.04.04.11:33
 * <p>
 * 166. Fraction to Recurring Decimal
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 *
 * @author : artairs
 */
class FractionToRecurringDecimal {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(4, 9));
        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal(22, 7));
        System.out.println(fractionToDecimal(-50, 8));
        System.out.println(fractionToDecimal(-1, -2147483648));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String fractionToDecimal(int num, int den) {
        if(num == 0){
            return "0";
        }

        long numerator = num,denominator = den;

        List<Long> devideList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if(numerator < 0 && denominator < 0){
            numerator = -numerator;
            denominator = -denominator;
        } else if(numerator < 0 || denominator < 0){
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
            sb.append("-");
        }

        if (numerator >= denominator) {
            sb.append(numerator / denominator);
            if (numerator % denominator == 0) {
                return sb.toString();
            } else {
                numerator %= denominator;
                sb.append(".");
            }
        } else {
            sb.append("0.");
        }

        numerator *= 10;
        devideList.add(numerator);

        while (true) {
            if (numerator % denominator == 0) {
                sb.append(numerator / denominator);
                return sb.toString();
            } else if (numerator < denominator) {
                numerator *= 10;
                if (devideList.contains(numerator)) {
                    int index = devideList.indexOf(numerator);
                    String decimals = sb.toString().substring(sb.toString().indexOf(".") + 1);
                    String nonRepeat = decimals.substring(0, index);
                    String Repeat = decimals.substring(index);

                    return sb.toString().substring(0, sb.toString().indexOf(".") + 1) + nonRepeat + "(" + Repeat + ")";
                } else {
                    devideList.add(numerator);
                    sb.append("0");
                }
            } else if (numerator > denominator) {
                sb.append(numerator/denominator);
                numerator %= denominator;
                numerator *= 10;

                if (devideList.contains(numerator)) {
                    int index = devideList.indexOf(numerator);
                    String decimals = sb.toString().substring(sb.toString().indexOf(".") + 1);
                    String nonRepeat = decimals.substring(0, index);
                    String Repeat = decimals.substring(index);

                    return sb.toString().substring(0, sb.toString().indexOf(".") + 1) + nonRepeat + "(" + Repeat + ")";
                }

                devideList.add(numerator);
            }
        }
    }

}
