package question;

/**
 * question
 * LeetCode
 * 2018.07.19.上午11:59\
 * <p>
 * 836. Rectangle Overlap
 * https://leetcode.com/problems/rectangle-overlap/description/
 *
 * @author : rick
 */
class RectangleOverlap {
    public static void main(String[] args) {

        int[] x1 = new int[]{2, 17, 6, 20};
        int[] x2 = new int[]{3, 8, 6, 20};

        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(isRectangleOverlap(x1, x2));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        int ax = rec1[0], ay = rec1[1];
        int bx = rec1[2], by = rec1[3];

        int cx = rec2[0], cy = rec2[1];
        int dx = rec2[2], dy = rec2[3];


        return bx > cx &&
                by > cy &&
                ax < dx &&
                ay < dy;
    }
}
