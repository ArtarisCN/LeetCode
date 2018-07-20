package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.07.20.下午2:21
 *
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/description/
 *
 * @author : rick
 */
class MinStack {

    List<Integer> stack = new ArrayList<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.add(x);
    }

    public void pop() {
        if(stack.size()  == 0)
            return;

        stack.remove(stack.size() - 1);
    }

    public int top() {
        if(stack.size() == 0)
            return 0;

        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        int min = stack.get(0);
        for (Integer integer : stack) {
            min = Math.min(integer,min);
        }
        return min;
    }
}
