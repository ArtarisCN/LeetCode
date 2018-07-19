package question;

/**
 * question
 * LeetCode
 * 2018.07.19.上午10:58
 * <p>
 * 832. Flipping an Image
 * https://leetcode.com/problems/flipping-an-image/description/
 *
 * @author : rick
 */
class FlippingAnImage {


    public static void main(String[] args) {

        int[][] x = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[][] y = flipAndInvertImage(x);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");

        for (int[] ints : y) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }

            System.out.println();
        }

    }

    public static int[][] flipAndInvertImage(int[][] A) {

        int x = 0X01;

        for (int[] ints : A) {
            for (int i = 0; i < ints.length; i++) {
                if (ints.length - i == i) {
                    break;
                }

                if (i == ints.length - i - 1) {
                    ints[i] ^= x;
                    break;
                } else {

                    ints[i] ^= ints[ints.length - i - 1];
                    ints[ints.length - i - 1] ^= ints[i];
                    ints[i] ^= ints[ints.length - i - 1];

                    ints[i] ^= x;
                    ints[ints.length - i - 1] ^= x;
                }
            }
        }

        return A;
    }

}
