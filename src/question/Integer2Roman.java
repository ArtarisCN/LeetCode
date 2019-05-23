package question;

import static util.QuestionUtils.getIntegerLength;

/**
 * question
 * LeetCode
 * 2018.04.18.下午6:41
 * <p>
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/description/
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * @author : rick
 */
class Integer2Roman {

    public static void main(String[] args) {

        System.out.println(intToRoman(1000));
    }

    public static String intToRoman(int num) {
        int size = getIntegerLength(num);
        int temp = num;
        int ruler = 1;
        int x;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size && temp != 0; i++) {

            x = temp % 10;
            temp /= 10;

            StringBuilder thisValue = new StringBuilder();

            switch (ruler) {
                case 1:
                    if (x < 4) {
                        for (int j = 0; j < x; j++) {
                            thisValue.append("I");
                        }
                    } else if (x == 4) {
                        thisValue.append("IV");
                    } else if (x == 5) {
                        thisValue.append("V");
                    } else if (x < 9) {
                        thisValue.append("V");
                        for (int j = x; j > 5; j--) {
                            thisValue.append("I");
                        }
                    } else {
                        thisValue.append("IX");
                    }
                    break;
                case 10:
                    if (x < 4) {
                        for (int j = 0; j < x; j++) {
                            thisValue.append("X");
                        }
                    } else if (x == 4) {
                        thisValue.append("XL");
                    } else if (x == 5) {
                        thisValue.append("L");
                    } else if (x < 9) {
                        thisValue.append("L");
                        for (int j = x; j > 5; j--) {
                            thisValue.append("X");
                        }
                    } else {
                        thisValue.append("XC");
                    }
                    break;
                case 100:
                    if (x < 4) {
                        for (int j = 0; j < x; j++) {
                            thisValue.append("C");
                        }
                    } else if (x == 4) {
                        thisValue.append("CD");
                    } else if (x == 5) {
                        thisValue.append("D");
                    } else if (x < 9) {
                        thisValue.append("D");
                        for (int j = x; j > 5; j--) {
                            thisValue.append("C");
                        }
                    } else {
                        thisValue.append("CM");
                    }
                    break;
                case 1000:
                    for (int j = 0; j < x; j++) {
                        thisValue.append("M");
                    }
                    break;
                default:
                    break;
            }

            result = thisValue.append(result);
            ruler *= 10;
        }
        return result.toString();
    }


}
