package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.11.02.15:51
 * <p>
 * 599. Minimum Index Sum of Two Lists
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 *
 * @author : artairs
 */
class MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        PrintUtils.printf(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}));

        PrintUtils.printf(findRestaurant(new String[]{"KFC", "Shogun", "Burger King"}, new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {

        int sum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();

        List<String> array1 = Arrays.asList(list1);
        List<String> array2 = Arrays.asList(list2);

        for (int i = 0; i < array1.size(); i++) {
            if (array2.contains(array1.get(i))) {
                if (sum == i + array2.indexOf(array1.get(i))) {
                    result.add(array1.get(i));
                } else if (i + array2.indexOf(array1.get(i)) < sum) {
                    sum = Math.min(i + array2.indexOf(array1.get(i)), sum);
                    result.clear();
                    result.add(array1.get(i));
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
