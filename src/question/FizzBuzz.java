package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.13.下午6:39
 *
 * 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/description/
 *
 * @author : rick
 */
class FizzBuzz {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();



        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            } else if(i % 3 == 0){
                result.add("Fizz");
            } else if(i % 3 == 0){
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;

    }


}
