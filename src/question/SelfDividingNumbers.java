package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.27.上午11:37
 *
 * 728. Self Dividing Numbers
 * https://leetcode.com/problems/self-dividing-numbers/description/
 *
 * @author : rick
 */
class SelfDividingNumbers {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<Integer> list = selfDividingNumbers(1,22);

        for (Integer integer : list) {
            System.out.println(integer);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList<>();

        for (int i = left;i < right + 1; i++){
            int index = i;

            boolean isSelfDividingNumber = true;

            while (index >0){

                int divider = index % 10;
                if(divider == 0 || i % divider != 0){
                    isSelfDividingNumber = false;
                    break;
                }
                index /= 10;
            }

            if(isSelfDividingNumber){
                result.add(i);
            }
        }

        return result;
    }
}
