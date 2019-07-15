package question;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2018.07.20.下午2:21
 * <p>
 * 155. Min Stack
 * https://leetcode.com/problems/min-stack/description/
 *
 * @author : rick
 */
class MinStack {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

/*        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());*/

        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        printf(stack);
        System.out.println(stack.top());
        System.out.println(stack.getMin());

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static void printf(MinStack stack) {
        PrintUtils.printfArrayList(stack.stack);
        PrintUtils.printfArrayList(stack.heap);
        System.out.println();
    }


    List<Integer> stack = new ArrayList<>();
    List<Integer> heap = new ArrayList<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.add(x);
        insertAndRefectMaxHeap(x);
    }

    private int popAndRefectMaxHeap() {
        int result = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        int index = 0;
        int sonIndex = index * 2;
        while (heap.get(sonIndex) > heap.get(index) || heap.get(sonIndex + 1) > heap.get(index)) {
            if (heap.get(sonIndex) > heap.get(index)) {
                heap.set(sonIndex, heap.get(sonIndex) + heap.get(index));
                heap.set(index, heap.get(sonIndex) - heap.get(index));
                heap.set(sonIndex, heap.get(sonIndex) - heap.get(index));

                index = sonIndex;
                sonIndex = index * 2;
            } else {
                heap.set(sonIndex, heap.get(sonIndex) + heap.get(index));
                heap.set(index, heap.get(sonIndex) - heap.get(index));
                heap.set(sonIndex, heap.get(sonIndex) - heap.get(index));

                index = sonIndex + 1;
                sonIndex = index * 2;
            }
        }
        return result;
    }

    private int removeAndRefectMaxHeap(int n) {
        if(n == heap.size() - 1){
            return heap.remove(heap.size() - 1);
        }
        int result = heap.get(n);
        heap.set(n, heap.remove(heap.size() - 1));
        int index = n;
        int sonIndex = index * 2 + 1;
        while ((sonIndex < heap.size()  && heap.get(sonIndex) < heap.get(index)) || (sonIndex < heap.size() - 1 && heap.get(sonIndex + 1) < heap.get(index))) {
            if(sonIndex != heap.size() - 1 && heap.get(sonIndex) > heap.get(sonIndex + 1)){
                sonIndex = sonIndex + 1;
            }
            heap.set(sonIndex, heap.get(sonIndex) + heap.get(index));
            heap.set(index, heap.get(sonIndex) - heap.get(index));
            heap.set(sonIndex, heap.get(sonIndex) - heap.get(index));

            index = sonIndex;
            sonIndex = index * 2 + 1;
        }
        return result;
    }

    private void insertAndRefectMaxHeap(int x) {
        heap.add(x);
        int index = heap.size() - 1;
        int parentIndex = index / 2;
        while (heap.get(index) < heap.get(parentIndex)) {
            heap.set(parentIndex, heap.get(parentIndex) + heap.get(index));
            heap.set(index, heap.get(parentIndex) - heap.get(index));
            heap.set(parentIndex, heap.get(parentIndex) - heap.get(index));

            index = parentIndex;
            parentIndex = index / 2;
        }
    }

    public int pop() {
        if (stack.size() == 0)
            return 0;

        int x = stack.remove(stack.size() - 1);
        int index = heap.indexOf(x);
        removeAndRefectMaxHeap(index);
        return x;
    }

    public int top() {
        if (stack.size() == 0)
            return 0;

        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return heap.get(0);
    }
}
