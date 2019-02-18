package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * question
 * LeetCode
 * 2018.12.05.11:05
 * <p>
 * 949.Largest Time for Given Digits
 * https://leetcode.com/problems/largest-time-for-given-digits/
 *
 * @author : artairs
 */
class LargestTimeForGivenDigits {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        System.out.println(largestTimeFromDigits(new int[]{0,0,0,0}));
//        System.out.println(largestTimeFromDigits(new int[]{0,4,4,4}));
        System.out.println(largestTimeFromDigits(new int[]{2,0,6,6}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String largestTimeFromDigits(int[] A) {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(A);

        List<List<Integer>> value = new ArrayList<>();
        value.add(Arrays.asList(0, 1, 2));
        value.add(Arrays.asList(0, 1, 2, 3));
        value.add(Arrays.asList(0, 1, 2, 3, 4, 5));
        value.add(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));


        List<Integer> sp = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        if (A[0] > 2) {
            return "";
        }

        List<Integer> time = Arrays.stream(A).boxed().collect(Collectors.toList());
        for (int l = 0; l < 4; l++) {
            List<Integer> copy = new ArrayList<>(time);
            if(l == 1 && (sb.toString().charAt(0) == '0' || sb.toString().charAt(0) == '1')){
                value.set(1,sp);
            }

            copy.retainAll(value.get(l));
            if (copy.size() == 0) {
                return "";
            } else {
                boolean find = false;
                for (int i = value.get(l).size() - 1; i >= 0; i--) {
                    if (time.contains(value.get(l).get(i))) {
                        sb.append(value.get(l).get(i));
                        time.set(time.indexOf(value.get(l).get(i)), -1);
                        find = true;
                        break;
                    }
                }

                if (!find) {
                    return "";
                }
            }
            if (l == 1) {
                sb.append(':');
            }
        }

        return sb.toString();
    }

}
