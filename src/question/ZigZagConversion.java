package question;

/**
 * question
 * LeetCode
 * 2018.04.16.下午6:44
 * <p>
 * 6. ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * @author : rick
 */

public class ZigZagConversion {
    public static void main(String[] args) {

        System.out.println("zigZagConversion(\"PAYPALISHIRING\", 3) = " + zigZagConversion("PAYPALISHIRING", 9));
    }


    private static String zigZagConversion(String s, int numRows) {

        if (s == null || "".equals(s) || numRows <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();


        int width = (s.length() / (2 * numRows - 2) + 1) * (numRows - 1) + 1;

        char[][] result = new char[numRows][width];


        int columns = 0, roll = 0;
        for (int i = 0; i < chars.length; i++) {
            if (roll == 0) {
                for (roll = 0; roll < numRows && i < chars.length; roll++, i++) {
                    result[roll][columns] = chars[i];
                }

                roll -= 2;
                columns++;
                i--;
            } else {
                result[roll][columns] = chars[i];
                roll--;
                columns++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < width; j++) {
                if (result[i][j] != '\u0000') {
                    stringBuilder.append(result[i][j]);
                }
            }

        }

        return stringBuilder.toString();

    }

}
