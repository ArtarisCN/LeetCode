package question;

/**
 * question
 * LeetCode
 * 2018.10.29.11:11
 * <p>
 * 859. Buddy Strings
 * https://leetcode.com/problems/buddy-strings/
 *
 * @author : artairs
 */
class BuddyStrings {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(buddyStrings("ab", "ab"));
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(buddyStrings("", "aa"));
        System.out.println(buddyStrings("abcaa", "abcbb"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        int ex = -1;
        char m = '.', n = '.';

        int[] letter = new int[26];

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                switch (ex) {
                    case -1:
                        ex = 0;
                        m = A.charAt(i);
                        n = B.charAt(i);
                        break;
                    case 0:
                        if (A.charAt(i) == n && B.charAt(i) == m) {
                            ex = 1;
                        } else {
                            return false;
                        }
                        break;
                    case 1:
                        return false;
                }
            } else {
                letter[A.charAt(i) - 'a']++;
            }
        }

        int same = 0;
        for (int i : letter) {
            if (i > 1) {
                same = 1;
                break;
            }
        }

        return ex == 1 || (ex == -1 && same == 1);
    }

}
