package question;

/**
 * question
 * LeetCode
 * 2018.11.01.17:02
 * <p>
 * 744. Find Smallest Letter Greater Than Target
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 *
 * @author : artairs
 */
class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        System.out.println(nextGreatestLetter(new char[]{'c','f','j'},'a'));
//        System.out.println(nextGreatestLetter(new char[]{'c','f','j'},'c'));
//        System.out.println(nextGreatestLetter(new char[]{'c','f','j'},'d'));
//        System.out.println(nextGreatestLetter(new char[]{'c','f','j'},'g'));
//        System.out.println(nextGreatestLetter(new char[]{'c','f','j'},'j'));
//        System.out.println(nextGreatestLetter(new char[]{'c','f','j'},'k'));
//        System.out.println(nextGreatestLetter(new char[]{'c','c','c','c','f','f'},'c'));
        System.out.println(nextGreatestLetter(new char[]{'e','e','e','k','q','q','q','v','v','y'},'q'));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }

        int start = 0, end = letters.length - 1;
        while (start < end) {
            if(letters[start] == target){
                int i = start;
                while (i < end){
                    i ++;
                    if(letters[i]!=letters[start]) {
                        return letters[i];
                    }
                }
                break;
            } else if(letters[end] == target){
                return letters[end + 1];
            } else if (letters[(start + end) / 2] == target) {
                int i = (start + end) / 2;
                while (i < end){
                    i ++;
                    if(letters[i]!=letters[(start + end) / 2]) {
                        return letters[i];
                    }
                }
                break;
            }  else if((end - start) < 2 && letters[start] < target && letters[end] > target){
                return letters[end];
            } else if (letters[(start + end) / 2] > target) {
                end = (start + end) / 2 ;
            } else {
                start = (start + end )/2 ;
            }
        }

        if(letters[start] < target && letters[end] > target){
            return letters[end];
        } else if(letters[start] < target && letters[end] < target){
            return letters[start];
        } else {
            return letters[end];
        }
    }
}
