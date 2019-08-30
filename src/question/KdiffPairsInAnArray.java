package question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * question
 * LeetCode
 * 2018.11.06.20:23
 * <p>
 * 532. K-diff Pairs in an Array
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 * @author : artairs
 */
class KdiffPairsInAnArray {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findPairs(new int[]{5,2,5,2,6,5,8,3,2,0}, 2));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findPairs(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);
        List<Integer> list = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());
        if (k == 0) {
            List<Integer> distinct = Arrays.stream(nums).boxed().collect(Collectors.toList());
            for (Integer integer : list) {
                if(distinct.indexOf(integer) != distinct.lastIndexOf(integer)){
                    result++;
                }
            }
            return result;
        } else if (k < 0) {
            return result;
        }
        int[] tag = new int[list.size()];
        Arrays.fill(tag, -1);
        for (int i = 0; i < list.size(); i++) {
            if (tag[i] != 0) {
                tag[i] = 0;
                int j = list.get(i) + k;
                while (j <= list.get(list.size() - 1)) {
                    if (list.indexOf(j) != -1) {
                        tag[list.indexOf(j)] = 0;
                        result++;
                    } else {
                        break;
                    }
                    j += k;
                }
            }
        }

        return result;
    }

}
