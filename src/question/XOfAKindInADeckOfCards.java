package question;

import java.util.HashMap;
import java.util.Map;

/**
 * question
 * LeetCode
 * 2018.10.25.17:14
 * <p>
 * 914. X of a Kind in a Deck of Cards
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 *
 * @author : artairs
 */
class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> nums = new HashMap<>();

        for (int i : deck) {
            if (nums.containsKey(i)) {
                nums.put(i, nums.get(i) + 1);
            } else {
                nums.put(i, 1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (Integer value : nums.values()) {
            if (value < 2) {
                return false;
            }

            if (value < min) {
                min = value;
            }
        }

        for (Integer value : nums.values()) {
            if (!hasRecursion(value, min)) {
                return false;
            }
        }

        return true;
    }


    private static boolean hasRecursion(int m, int n) {
        while (n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }

        return m > 1;
    }

}
