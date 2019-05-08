package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.10.23.10:50
 * <p>
 * 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * @author : artairs
 */
class FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(firstUniqChar("yekbsxznylrwamcaugrqrurvpqybkpfzwbqiysrdnrsnbftvrnszfjbkbmrctjizkjqoxqzddyfnavnhqeblfmzqgsjflghaulbadwqsyuetdelujphmlgtmkoaoijypvcajctbaumeromgejtewbwqptotrorephegyobbstvywljboeihdliknluqdpgampjyjpinxhhqexoctysfdciqjbzilnodzoihihusxluqoayenluziobxiodrfdkinkzzozmxfezfvllpdvogqqtquwcsijwachefspywdgsohqtlquhnoecccgbkrzqcprzmwvygqwddnehhi"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int firstUniqChar(String s) {
        if(s == null || s.length() < 1){
            return -1;
        }

        char[] chars = s.toCharArray();
        int[] codes = new int[26];
        List<Integer> index = new ArrayList<>();

        for (int i = 0; i < codes.length; i++) {
            codes[i] = -1;
        }

        for (int i = 0; i < chars.length; i++) {
            if (codes[chars[i] - 'a'] == -1) {
                codes[chars[i] - 'a'] = i;
                index.add(chars[i] - 'a');
            } else {
                codes[chars[i] - 'a'] = -2;
            }
        }

        for (int i : index) {
            if (codes[i] >= 0) {
                return codes[i];
            }
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        int result = -1;
        for(int i='a';i<='z';i++){
            int first = s.indexOf(i);
            if(first!=-1){
                int last = s.lastIndexOf(i);
                if(first==last)
                    result = result==-1? first:Math.min(result,last);
            }
        }
        return result;
    }

}
