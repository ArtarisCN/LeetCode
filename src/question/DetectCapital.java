package question;

/**
 * question
 * LeetCode
 * 2018.07.20.上午10:30
 *
 * 520. Detect Capital
 * https://leetcode.com/problems/detect-capital/description/
 *
 * @author : rick
 */
class DetectCapital {

    public static void main(String[] args) {


        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(detectCapitalUse("aUSA"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean detectCapitalUse(String word) {

        /**
         * 0:全小写
         * 1：首字母大写
         * 2：全大写
         */
        int status = -1;

        int count = -1;

        for (int i = 0; i < word.length(); i++) {
            if (i == 0) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    status = 1;
                } else {
                    status = 0;
                    count = 0;
                }
                continue;
            }

            if (status == 0) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    return false;
                } else {
                    continue;
                }
            }

            if (status == 1) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                    if (count == 1) {
                        return false;
                    } else {
                        status = 2;
                        count = 2;
                    }
                } else {
                    count = 1;
                }
                continue;
            }

            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                return false;
            } else {
                count = 1;
            }
        }
        return true;

    }
}
