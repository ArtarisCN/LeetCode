package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.04.19.下午5:56
 * <p>
 * SingleNumberIII
 * https://leetcode.com/problems/single-number-iii/description/
 *
 * @author : rick
 */
class SingleNumberIII {

    public static void main(String[] args) {

        int[] res = singleNumber(new int[]{43772400, 1674008457, 1779561093, 744132272, 1674008457, 448610617, 1779561093, 124075538, -1034600064, 49040018, 612881857, 390719949, -359290212, -812493625, 124732, -1361696369, 49040018, -145417756, -812493625, 2078552599, 1568689850, 865876872, 865876872, -1471385435, 1816352571, 1793963758, 2078552599, -1034600064, 1475115274, -119634980, 124732, 661111294, -1813882010, 1568689850, 448610617, 1347212898, -1293494866, 612881857, 661111294, -1361696369, 1816352571, -1813882010, -359290212, 1475115274, 1793963758, 1347212898, 43772400, -1471385435, 124075538, -1293494866, -119634980, 390719949});
        for (int re : res) {
            System.out.println(re);
        }
    }

    public static int[] singleNumber(int[] nums) {

        int flag = singleNumberIndex(nums);

        List<Integer> first = new ArrayList<>(), second = new ArrayList<>();

        for (int num : nums) {
            if ((num & flag) == flag) {
                first.add(num);
            } else {
                second.add(num);
            }
        }

        int[] result = new int[2];

        flag = 0;
        for (Integer integer : first) {
            flag ^= integer;
        }

        result[0] = flag;
        flag = 0;

        for (Integer integer : second) {
            flag ^= integer;
        }

        result[1] = flag;

        return result;
    }

    public static int singleNumberIndex(int[] nums) {
        int v = 0;
        for (int num : nums) {
            v ^= num;
        }

        int result = 1;

        while (v > 1) {
            if (v % 2 == 1) {
                return result;
            } else {
                v >>>= 1;
                result <<= 1;
            }
        }

        return result;
    }
}
