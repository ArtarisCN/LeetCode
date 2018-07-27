package question;

/**
 * question
 * LeetCode
 * 2018.07.27.上午11:15
 * <p>
 * 657. Judge Route Circle
 * https://leetcode.com/problems/judge-route-circle/description/
 *
 * @author : rick
 */
class JudgeRouteCircle {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(judgeCircle("LL"));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean judgeCircle(String moves) {

        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'U':
                    y++;
                    break;
                default:
                    return false;
            }
        }

        return x == 0 && y == 0;
    }
}
