package question;

import java.util.Arrays;

/**
 * question
 * LeetCode
 * 2018.07.19.下午5:41
 *
 * @author : rick
 */
class Heaters {

    public static void main(String[] args) {


        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findRadius(new int[]{1,2,3,5,15},new int[]{2,30}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);

        int type = 0,maxLength =0;
        Arrays.sort(heaters);

        maxLength = Math.max(heaters[0] - houses[0],houses[houses.length -1 ]-  heaters[heaters.length -1]);

        for (int i = 0; i < heaters.length - 1; i++) {
            if(heaters[i + 1] - heaters[i] > maxLength){
                maxLength = heaters[i + 1] - heaters[i];
                type = 1;
            }
        }

        if(type == 0){
            return maxLength;
        } else {
            return maxLength / 2;
        }

    }

}
