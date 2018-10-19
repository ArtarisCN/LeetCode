package question;

import java.util.Stack;

/**
 * question
 * LeetCode
 * 2018.10.19.16:20
 * <p>
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * @author : artairs
 */
class ImplementQueueUsingStacks {

    class MyQueue {

        private Stack<Integer> queueA;
        private Stack<Integer> queueB;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            queueA = new Stack<>();
            queueB = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (queueA.empty()) {
                while (queueB.empty()) {
                    queueA.push(queueB.pop());
                }
            }

            queueA.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (queueB.empty()) {
                while (queueA.empty()) {
                    queueB.push(queueA.pop());
                }
            }
            return queueB.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (queueB.empty()) {
                while (queueA.empty()) {
                    queueB.push(queueA.pop());
                }
            }
            return queueB.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return queueB.empty() && queueA.empty();
        }
    }

}
