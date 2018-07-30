package question;

import java.util.Stack;

/**
 * question
 * LeetCode
 * 2018.07.27.下午6:44
 * <p>
 * 682. Baseball Game
 * https://leetcode.com/problems/baseball-game/description/
 *
 * @author : rick
 */
class BaseballGame {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        String[] ops = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};

        System.out.println(calPoints(ops));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int calPoints(String[] ops) {

        Stack<Integer> scores = new Stack<>();

        char plus = '+', add = 'D', cancel = 'C';

        int previousScore, previousPreviousScore;

        for (String op : ops) {
            if (op.length() > 1) {

                int score = Integer.valueOf(op);

                scores.push(score);
                continue;
            } else {
                char operation = op.charAt(0);

                if (operation >= '0' && operation <= '9') {
                    int score = Integer.valueOf(op);
                    scores.push(score);
                    continue;
                } else {
                    if (operation == plus) {
                        previousScore = scores.pop();
                        previousPreviousScore = scores.peek();

                        int thisScore = previousScore + previousPreviousScore;
                        scores.push(previousScore);
                        scores.push(thisScore);

                    } else if (operation == add) {
                        previousScore = scores.peek();
                        int thisScore = previousScore * 2;
                        scores.push(thisScore);

                    } else if (operation == cancel) {
                        scores.pop();
                    }

                }

            }

        }


        int result = 0;

        while (!scores.empty()) {
            result += scores.pop();
        }

        return result;
    }


}
