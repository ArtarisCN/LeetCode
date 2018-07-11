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

        int[] array = new int[getIntegerLength(num)];
        int temp = num;

        int ruler = 1;

        String result = "";

        int x = 0;

        for (int i = 0; i < array.length && temp != 0; i++) {

            x = temp % 10;
            temp /= 10;

            String thisValue = "";

            switch (ruler) {
                case 1:
                    if (x < 4) {
                        for (int j = 0; j < x; j++) {
                            thisValue += "I";
                        }
                    } else if (x == 4) {
                        thisValue += "IV";
                    } else if (x == 5) {
                        thisValue += "V";
                    } else if (x < 9) {
                        thisValue += "V";
                        for (int j = x; j > 5; j--) {
                            thisValue += "I";
                        }
                    } else {
                        thisValue += "IX";
                    }
                    break;
                case 10:
                    if (x < 4) {
                        for (int j = 0; j < x; j++) {
                            thisValue += "X";
                        }
                    } else if (x == 4) {
                        thisValue += "XL";
                    } else if (x == 5) {
                        thisValue += "L";
                    } else if (x < 9) {
                        thisValue += "L";
                        for (int j = x; j > 5; j--) {
                            thisValue += "X";
                        }
                    } else {
                        thisValue += "XC";
                    }
                    break;
                case 100:
                    if (x < 4) {
                        for (int j = 0; j < x; j++) {
                            thisValue += "C";
                        }
                    } else if (x == 4) {
                        thisValue += "CD";
                    } else if (x == 5) {
                        thisValue += "D";
                    } else if (x < 9) {
                        thisValue += "D";
                        for (int j = x; j > 5; j--) {
                            thisValue += "C";
                        }
                    } else {
                        thisValue += "CM";
                    }
                    break;
                case 1000:
                    for (int j = 0; j < x; j++) {
                        thisValue += "M";
                    }
                    break;
                default:
                    break;
            }

            result = thisValue + result;

            ruler *= 10;
        }


        return result;
    }


}
