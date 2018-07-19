package question;

/**
 * question
 * LeetCode
 * 2018.07.19.下午5:02
 *
 * 482. License Key Formatting
 * https://leetcode.com/problems/license-key-formatting/description/
 *
 * @author : rick
 */
class LicenseKeyFormatting {

    public static void main(String[] args) {


        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(licenseKeyFormatting("2", 4));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static String licenseKeyFormatting(String S, int K) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        boolean isFirstGroup = true;

        StringBuilder temp = new StringBuilder(S);
        S = temp.reverse().toString();
        temp = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {
                continue;
            }

            count++;
            temp.append(S.charAt(i));

            if (count == K) {
                if (!isFirstGroup) {
                    sb.append("-");
                }
                isFirstGroup = false;
                sb.append(temp.toString().toUpperCase());
                count = 0;
                temp = new StringBuilder();
            }
        }

        if (temp.toString().length() > 0) {
            if (!isFirstGroup) {
                sb.append("-");
            }
            sb.append(temp.toString().toUpperCase());
        }

        return sb.reverse().toString();
    }

}
