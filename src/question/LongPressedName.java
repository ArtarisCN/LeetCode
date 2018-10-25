package question;

/**
 * question
 * LeetCode
 * 2018.10.25.14:47
 * <p>
 * 925. Long Pressed Name
 * https://leetcode.com/problems/long-pressed-name/
 *
 * @author : artairs
 */
class LongPressedName {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));
        System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static boolean isLongPressedName(String name, String typed) {
        for (int i = 0; i < typed.length(); i++) {
            if (typed.charAt(i) == name.charAt(0)) {
                boolean success = true;
                int x = i + 1;

                for (int y = 1; x < typed.length() && y < name.length();) {
                    if (name.charAt(y) == typed.charAt(x)){
                        x ++;
                        y ++;
                        continue;
                    }

                    if (name.charAt(y - 1) == typed.charAt(x)){
                        x ++;
                        continue;
                    }

                    success = false;
                    break;
                }

                if(name.charAt(name.length() - 1) != typed.charAt(x - 1) ){
                    return false;
                }

                if (success) {
                    return true;
                }
            }
        }

        return false;
    }
}
