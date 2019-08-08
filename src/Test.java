import java.util.Arrays;

/**
 * PACKAGE_NAME
 * LeetCode
 * 2019.07.24.16:05
 *
 * @author : artairs
 */
public class Test {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[] num = new int[]{1,2,3,4,5,6,7,8,9,10};

        Arrays.fill(num,-1,32,4);
        for (int te : num) {
            System.out.println(te);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static int searchIndex(int[] num,int target){
        int left = 0,right = num.length - 1;
        while (left <= right){
            int index = (left + right)/2;
            System.out.print(index + " ");
            if(num[index] < target){
                left = index + 1;
            } else if(num[index] > target){
                right = index - 1;
            } else if(num[index] == target){
                return index;
            }
        }
        System.out.println();
        return -1;
    }

    public static int info(int x, double y) {
        return 0;
    }

    public static int info(int x, int y) {
        return 0;
    }
}