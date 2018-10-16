package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.09.29.16:31\
 *
 * 849. Maximize Distance to Closest Person
 *
 * @author : artairs
 */
class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public int maxDistToClosest(int[] seats) {
        Map<Integer,Boolean> value =  new HashMap<>();

        boolean open = true,find = false;
        int lenght = 0;
        for (int i = seats.length - 1; i >= 0; i--) {
            if(seats[i] == 0){
                lenght ++;
            } else {
                if(find){

                } else {

                }

                open = false;
            }



        }

        return 0;
    }
}
