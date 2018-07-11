package question;

/**
 * question
 * LeetCode
 * 2018.04.19.下午3:10
 * <p>
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/description/
 *
 * @author : rick
 */
class Roman2Integer {

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }

    public static int romanToInt(String s) {

        int result = 0;

        String[] M = {"M", "MM", "MMM"};
        String[] C = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String temp = s;

        while (temp.length() > 0) {

            switch (temp.charAt(0)) {
                case 'I':
                case 'V':
                    for (int i = I.length - 1; i >= 0; i--) {
                        if (temp.startsWith(I[i])) {
                            result += i + 1;
                            temp = temp.substring(I[i].length());
                            break;
                        }
                    }
                    break;
                case 'X':
                case 'L':
                    for (int i = X.length - 1; i >= 0; i--) {
                        if (temp.startsWith(X[i])) {
                            result += (i + 1) * 10;
                            temp = temp.substring(X[i].length());
                            break;
                        }
                    }
                    break;
                case 'C':
                case 'D':
                    for (int i = C.length - 1; i >= 0; i--) {
                        if (temp.startsWith(C[i])) {
                            result += (i + 1) * 100;
                            temp = temp.substring(C[i].length());
                            break;
                        }
                    }
                    break;
                case 'M':
                    for (int i = M.length - 1; i >= 0; i--) {
                        if (temp.startsWith(M[i])) {
                            result += (i + 1) * 1000;
                            temp = temp.substring(M[i].length());
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }

        }

        return result;
    }

}
