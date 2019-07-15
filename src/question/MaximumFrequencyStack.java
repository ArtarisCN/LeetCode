package question;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;

/**
 * question
 * LeetCode
 * 2019.07.15.16:28
 *
 * 895. Maximum Frequency Stack
 * https://leetcode.com/problems/maximum-frequency-stack/
 *
 * @author : artairs
 */
class MaximumFrequencyStack {


    class FreqStack {

        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxfreq;

        public FreqStack() {
            freq = new HashMap<>();
            group = new HashMap<>();
            maxfreq = 0;
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            if (f > maxfreq) maxfreq = f;
            group.computeIfAbsent(f, new Function<Integer, Stack<Integer>>() {
                @Override
                public Stack<Integer> apply(Integer integer) {
                    return new Stack<>();
                }
            }).push(x);
        }

        public int pop() {
            int x = group.get(maxfreq).pop();
            freq.put(x, freq.get(x) - 1);
            if (group.get(maxfreq).size() == 0)
                maxfreq--;
            return x;
        }
    }

}
