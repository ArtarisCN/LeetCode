package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.07.13.上午11:28
 *
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say/description/
 *
 * @author : rick
 */
class CountAndSay {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(countAndSay(6));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String countAndSay(int n) {

        Map<String, String> valueTransform = new HashMap<>();

        StringBuilder sb;
        String currentString = "1";

        valueTransform.put("1", "11");

        while (n > 1) {

            String thisStr = new String(currentString);
            sb = new StringBuilder();

            char[] currentChars = currentString.toCharArray();
            String transform;

            for (int i = 0; i < currentChars.length;) {
                if (currentChars.length == 1) {

                    if (valueTransform.containsKey(String.valueOf(currentChars[0]))) {
                        sb.append(valueTransform.get(String.valueOf(currentChars[0])));
                    } else {
                        int length = 1;
                        int value = currentChars[0] - '0';

                        String temp = String.valueOf(length) + String.valueOf(value);
                        valueTransform.put(String.valueOf(currentChars[0]), temp);

                        sb.append(temp);
                    }

                    break;
                }

                if (i == currentChars.length - 1) {
                    int index;

                    if(currentChars[0] != currentChars[i]) {
                        index = i;
                    } else {
                        index = i + 1;
                    }

                    transform = currentString.substring(0, index);
                    if (valueTransform.containsKey(transform)) {
                        sb.append(valueTransform.get(transform));
                    } else {
                        int length = transform.length();
                        int value = transform.charAt(0) - '0';

                        String temp = String.valueOf(length) + String.valueOf(value);
                        valueTransform.put(transform, temp);

                        sb.append(temp);
                    }

                    currentString = currentString.substring(i + 1);
                    currentChars = currentString.toCharArray();
                    i = 0;
                    continue;
                }

                if (currentChars[0] != currentChars[i + 1]) {
                    transform = currentString.substring(0, i + 1);
                    if (valueTransform.containsKey(transform)) {
                        sb.append(valueTransform.get(transform));
                    } else {
                        int length = transform.length();
                        int value = transform.charAt(0) - '0';

                        String temp = String.valueOf(length) + String.valueOf(value);
                        valueTransform.put(transform, temp);

                        sb.append(temp);
                    }

                    currentString = currentString.substring(i + 1);
                    currentChars = currentString.toCharArray();
                    i = 0;
                    continue;
                }

                i++;
            }

            currentString = sb.toString();
            valueTransform.put(thisStr, currentString);
            n--;
        }

        return currentString;

    }

}
