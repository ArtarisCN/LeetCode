package question;

/**
 * 3
 * Created by rick on 2017/7/18.
 */
class LengthOfLongestSubstring {
    static int lengthOfLongestSubstring(String s) {
        int length = s.length();

        if (length == 0)
            return 0;

        int maxLength = 1;

        for (int i = 0; i < length; i++) {

            int[] chars = new int[150];
            for (int i1 = 0; i1 < chars.length; i1++) {
                chars[i1] = -1;
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
        }
        return maxLength;
    }
}
