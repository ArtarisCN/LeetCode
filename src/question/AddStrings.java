package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午5:23
 * <p>
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/description/
 *
 * @author : rick
 */
class AddStrings {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(addStrings("9999","1111"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String addStrings(String num1, String num2) {

        char[] aArr = num1.toCharArray(), bArr = num2.toCharArray();

        int length = Math.max(num1.length(), num2.length());

        StringBuilder sb = new StringBuilder();
        if (num1.length() > num2.length()) {
            sb.append(num2);
            sb.reverse();

            for (int i = num1.length() - num2.length(); i > 0; i--) {
                sb.append("0");
            }

            bArr = sb.reverse().toString().toCharArray();
        } else {
            sb.append(num1);
            sb.reverse();

            for (int i = num2.length() - num1.length(); i > 0; i--) {
                sb.append("0");
            }

            aArr = sb.reverse().toString().toCharArray();
        }

        sb = new StringBuilder();

        int sub = 0;

        for (int i = 1; i < length + 1; i++) {

            int plus = aArr[aArr.length - i] + bArr[bArr.length - i] + sub - '0' - '0';
            if (plus >= 10) {
                sb.append(plus % 10);
                sub = 1;
            } else {
                sb.append(plus);
                sub = 0;
            }
        }

        if (sub == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }


}
