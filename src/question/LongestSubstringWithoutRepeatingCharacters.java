package question;

/**
 * question
 * LeetCode
 * 2019.04.29.14:17
 *
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author : artairs
 */
class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0)
            return 0;

        int maxLength = 1;
        for (int i = 0; i < length; i++) {

            int[] chars = new int[150];
            for (int j = 0; j < chars.length; j++) {
                chars[j] = -1;
            }

            int thisMaxLength = -1;
            chars[s.charAt(i)] = i;

            for (int j = i + 1; j < length; j++) {
                char x = s.charAt(j);
                if (chars[x] != -1) {
                    thisMaxLength = j - i;
                    break;
                } else {
                    chars[x] = j;
                }
            }

            if (thisMaxLength == -1) {
                thisMaxLength = length - i;
            }

            if (thisMaxLength > maxLength) {
                maxLength = thisMaxLength;
            }

            //剩余的子串都不如目前的大，则不用再检查了
            if(length - i < maxLength){
                break;
            }
        }
        return maxLength;
    }
}
