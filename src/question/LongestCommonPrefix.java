package question;

/**
 * question
 * LeetCode
 * 2018.04.18.下午5:33
 * <p>
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * @author : rick
 */
class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"a", "ac"}));
    }


    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        if ("".equals(strs[0])) {
            return "";
        }

        String prefix = "";

        for (int i = 1; i <= strs[0].length(); i++) {

            String temp = strs[0].substring(0, i);

            boolean flag = true;

            for (int j = 1; j < strs.length; j++) {

                if (!strs[j].startsWith(temp)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                break;
            }
            prefix = temp;

        }
        return prefix;
    }
}
