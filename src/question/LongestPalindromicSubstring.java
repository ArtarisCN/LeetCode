package question;

/**
 * question
 * LeetCode
 * 2019.07.12.10:39
 * <p>
 * 5. Longest Palindromic Substring
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author : artairs
 */
class LongestPalindromicSubstring {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(longestPalindrome2("cbbd"));
        System.out.println(longestPalindrome2("babad"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String longestPalindrome2(String s) {
        StringBuilder sb = new StringBuilder("$");
        for (int i = 0; i < s.length(); i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#@");
        String process = sb.toString();
        int[] manacher = new int[process.length()];
        int reachRight = 0, reachCenter = 1;
        for (int i = 1; i < process.length() - 1; i++) {
            int mirrorI = 2 * reachCenter - i;
            if (reachRight > i) {
                manacher[i] = Math.min(reachRight - i, manacher[mirrorI]);// 防止超出 reachRight
            } else {
                manacher[i] = 0;// 等于 reachRight 的情况
            }

            // 碰到之前讲的三种情况时候，需要利用中心扩展法
            while (process.charAt(i + 1 + manacher[i]) == process.charAt(i - 1 - manacher[i])) {
                manacher[i]++;
            }

            // 判断是否需要更新 reachRight
            if (i + manacher[i] > reachRight) {
                reachCenter = i;
                reachRight = i + manacher[i];
            }

        }

        // 找出 manacher 的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < process.length() - 1; i++) {
            if (manacher[i] > maxLen) {
                maxLen = manacher[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2; //最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }


    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int length = s.length();
        boolean[][] nums = new boolean[length][length];
        int maxI = 0, maxJ = 0, maxValue = 0;
        for (int i = 0; i < length; i++) {
            nums[i][i] = true;
            for (int j = 0; j < i; j++) {
                nums[j][i] = (s.charAt(i) == s.charAt(j) && (i - j < 2 || nums[j + 1][i - 1]));
                if (nums[j][i] && maxValue < i - j + 1) {
                    maxValue = i - j + 1;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return s.substring(maxJ, maxI + 1);
    }
}
