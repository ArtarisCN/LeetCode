package question;

/**
 * question
 * LeetCode
 * 2019.04.03.18:39
 * <p>
 * 593. Valid Square
 * https://leetcode.com/problems/valid-square/
 *
 * @author : artairs
 */
class ValidSquare {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(validSquare(new int[]{0, 0},
                new int[]{1, 1},
                new int[]{1, 0},
                new int[]{0, 1}));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        if (p1[0] == p2[0] && p2[0] == p3[0] && p3[0] == p4[0] &&
                p1[1] == p2[1] && p2[1] == p3[1] && p3[1] == p4[1]) {
            return false;
        }

        return check(p1, p2, p3, p4) || check(p1, p2, p4, p3) || check(p1, p3, p2, p4) || check(p1, p3, p4, p2) || check(p1, p4, p3, p2) || check(p1, p4, p2, p3) ||
                check(p2, p1, p3, p4) || check(p2, p1, p4, p3) || check(p2, p3, p1, p4) || check(p2, p3, p4, p1) || check(p2, p4, p1, p3) || check(p2, p4, p3, p1) ||
                check(p3, p1, p2, p4) || check(p3, p1, p4, p2) || check(p3, p2, p4, p1) || check(p3, p2, p1, p4) || check(p3, p4, p2, p1) || check(p3, p4, p1, p2) ||
                check(p4, p3, p2, p1) || check(p4, p3, p1, p2) || check(p4, p2, p1, p3) || check(p4, p2, p3, p1) || check(p4, p1, p2, p3) || check(p4, p1, p3, p2);
    }

    private static boolean check(int[] b1, int[] b2, int[] b3, int[] b4) {
        int[] vector1 = new int[]{b3[0] - b1[0], b3[1] - b1[1]}, vector2 = new int[]{b4[0] - b2[0], b4[1] - b2[1]};

        return (Math.pow((b3[0] - b1[0]), 2) + Math.pow((b3[1] - b1[1]), 2) == Math.pow(b4[1] - b2[1], 2) + Math.pow(b4[0] - b2[0], 2)) &&//对角线相等
                (vector1[0] * vector2[0] + vector1[1] * vector2[1] == 0) && //对角线垂直
                ((b3[0] - b2[0]) * (b4[1] - b1[1]) == ((b3[1] - b2[1]) * (b4[0] - b1[0]))) &&//对边平行
                ((b3[0] - b4[0]) * (b2[1] - b1[1]) == ((b3[1] - b4[1]) * (b2[0] - b1[0]))) &&
                (Math.pow((b3[0] - b2[0]), 2) + Math.pow((b3[1] - b2[1]), 2) == Math.pow(b3[0] - b4[0], 2) + Math.pow(b3[1] - b4[1], 2) &&//边长相等
                        Math.pow((b3[0] - b2[0]), 2) + Math.pow((b3[1] - b2[1]), 2) == Math.pow(b4[0] - b1[0], 2) + Math.pow(b4[1] - b1[1], 2) &&
                        Math.pow((b3[0] - b2[0]), 2) + Math.pow((b3[1] - b2[1]), 2) == Math.pow(b1[0] - b2[0], 2) + Math.pow(b1[1] - b2[1], 2));
    }
}
