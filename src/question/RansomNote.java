package question;

/**
 * question
 * LeetCode
 * 2018.07.13.下午6:22
 *
 * 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/description/
 *
 * @author : rick
 */
class RansomNote {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(canConstruct("aa", "ab"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] letter = new int[128];

        for (int i = 0; i < magazine.length(); i++) {
            letter[magazine.charAt(i)] ++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            letter[ransomNote.charAt(i)] --;

            if(letter[ransomNote.charAt(i)] < 0){
                return false;
            }
        }

        return true;

    }
}
