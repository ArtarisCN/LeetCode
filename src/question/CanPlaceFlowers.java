package question;

/**
 * question
 * LeetCode
 * 2018.10.16.17:10
 * <p>
 * 605.Can Place Flowers
 * https://leetcode.com/problems/can-place-flowers/
 *
 * @author : artairs
 */
class CanPlaceFlowers {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(canPlaceFlowers(new int[]{1},0));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int canPlace = 0;

        if(flowerbed.length == 1 ){
            return flowerbed[0] + n <= 1;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0){
                if(i == 0){
                    if(flowerbed[1] == 0) {
                        canPlace++;
                        flowerbed[i] = 1;
                    }
                    continue;
                }

                if(i == flowerbed.length - 1){
                    if(flowerbed[flowerbed.length - 2] == 0) {
                        canPlace++;
                        flowerbed[i] = 1;
                    }
                    continue;
                }

                if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                    canPlace ++;
                    flowerbed[i] = 1;
                    continue;
                }
            }
        }


        System.out.println(canPlace);
        return canPlace >= n;
    }

}
