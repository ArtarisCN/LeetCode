package question;

import java.util.ArrayList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2018.10.19.16:15
 * <p>
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * @author : artairs
 */
class ImplementStackUsingQueues {

    private List<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {
        stack = new ArrayList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        stack.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (stack.size() == 0) {
            return 0;
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (stack.size() == 0) {
            return 0;
        }
        return stack.get(stack.size() - 1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return stack.size() == 0;
    }

}
