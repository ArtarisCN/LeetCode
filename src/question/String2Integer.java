package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.04.17.下午4:25
 * <p>
 * 8. String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * @author : rick
 */
class String2Integer {

    public static void main(String[] args) {
        System.out.println(myAtoi("-13+8"));
    }

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        boolean legal = false;
        /**
         * -1:负号
         * 1：正号
         */
        int sign = 0;

        List<Integer> resultArray = new ArrayList<>();

        for (char aChar : chars) {
            if (aChar == ' ') {
                if (!legal) {
                    continue;
                } else {
                    break;
                }
            }
            if (aChar == '-') {
                if (sign == 0) {
                    sign = -1;
                    legal = true;
                    continue;
                } else if (legal) {
                    break;
                } else {
                    return 0;
                }
            }

            if (aChar == '+') {
                if (sign == 0) {
                    sign = 1;
                    legal = true;
                    continue;
                } else if (legal) {
                    break;
                } else {
                    return 0;
                }
            }

            if (aChar == '.') {
                break;
            }


            if (aChar > '9' || aChar < '0') {
                if (!legal) {
                    return 0;
                }

                break;
            }

            if (sign == 0) {
                sign = 1;
            }

            legal = true;
            resultArray.add(Integer.valueOf(String.valueOf(aChar)));
        }

        int result = 0;

        for (int i = resultArray.size() - 1; i >= 0; i--) {
            if (result + resultArray.get(i) * Math.pow(10, resultArray.size() - i - 1) > Integer.MAX_VALUE) {
                switch (sign) {
                    case 0:
                    case 1:
                        return Integer.MAX_VALUE;
                    case -1:
                        return -Integer.MAX_VALUE - 1;
                    default:
                        return Integer.MAX_VALUE;
                }
            }

            result += resultArray.get(i) * Math.pow(10, resultArray.size() - i - 1);
        }

        return sign == 0 ? result : sign * result;
    }

}
