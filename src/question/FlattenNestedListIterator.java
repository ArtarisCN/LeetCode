package question;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * question
 * LeetCode
 * 2019.07.04.14:31
 * <p>
 * 341. Flatten Nested List Iterator
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 *
 * @author : artairs
 */
class FlattenNestedListIterator {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public class NestedIterator implements Iterator<Integer> {
        Deque<Integer> mDeque = new LinkedList<>();
        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if(nestedInteger.isInteger()){
                    mDeque.add(nestedInteger.getInteger());
                } else {
                    NestedIterator nestedIterator = new NestedIterator(nestedInteger.getList());
                    while (nestedIterator.hasNext()){
                        mDeque.add(nestedIterator.next());
                    }
                }
            }
        }

        @Override
        public Integer next() {
            return mDeque.remove();
        }

        @Override
        public boolean hasNext() {
            return mDeque.size() != 0;
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

}
