package question;

import java.util.HashSet;
import java.util.Set;

/**
 * question
 * LeetCode
 * 2018.07.30.下午6:36
 * <p>
 * 575. Distribute Candies
 * https://leetcode.com/problems/distribute-candies/description/
 *
 * @author : rick
 */
class DistributeCandies {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(distributeCandies(new int[]{1,1}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int distributeCandies(int[] candies) {

        Set<Integer> sister = new HashSet<>();
        Set<Integer> bro = new HashSet<>();

        int l = candies.length / 2, s = 0, b = 0;

        for (int candy : candies) {
            if (s == l) {
                return sister.size();
            }

            if (!sister.contains(candy)) {
                sister.add(candy);
                s++;
            } else {
                if (bro.contains(candy)) {
                    switch (s - b) {
                        case -1:
                            s++;
                            break;
                        case 1:
                            b++;
                            break;
                        case 0:
                            b++;
                            break;
                        default:
                            b++;
                            break;
                    }
                } else {
                    bro.add(candy);
                    b++;
                }
            }
        }

        return sister.size();
    }


}
