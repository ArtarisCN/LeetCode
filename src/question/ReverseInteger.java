package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.04.17.下午2:48
 * <p>
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * @author : rick
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println("reverse(- 200) = " + reverse(-2147483648));
    }

    public static int reverse(int x) {

        if (x == 0 || x == -2147483648) {
            return 0;
        }

        boolean sign = x > 0;

        x = Math.abs(x);

        List<Integer> integers = new ArrayList<>();

        int temp = x;
        while (temp != 0) {

            integers.add(temp % 10);
            temp = temp / 10;
        }


        int result = 0;
        for (int i = integers.size() - 1; i >= 0; i--) {
            if (result + integers.get(i) * Math.pow(10, integers.size() - i - 1) > Integer.MAX_VALUE) {
                return 0;
            }

            result += integers.get(i) * Math.pow(10, integers.size() - i - 1);
        }

        return sign ? result : -result;


    }
}
