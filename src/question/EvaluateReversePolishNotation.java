package question;

import java.util.Stack;

/**
 * question
 * LeetCode
 * 2019.07.04.10:45
 *
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * @author : artairs
 */
class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(evalRPN(new String[]{
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        }));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int second = number.pop();
                    int first = number.pop();
                    number.push(first + second);
                    break;
                }
                case "-": {
                    int second = number.pop();
                    int first = number.pop();
                    number.push(first - second);
                    break;
                }
                case "*": {
                    int second = number.pop();
                    int first = number.pop();
                    number.push(first * second);
                    break;
                }
                case "/": {
                    int second = number.pop();
                    int first = number.pop();
                    number.push(first / second);
                    break;
                }
                default:
                    number.push(Integer.valueOf(token));
                    break;
            }
        }
        return number.pop();
    }
}
