package question;

import model.ListNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.29.10:47
 * <p>
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 *
 * @author : artairs
 */
class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        System.out.println(middleNode(QuestionUtils.buildLinkedList(new int[]{})).val);
        System.out.println(middleNode(QuestionUtils.buildLinkedList(new int[]{1})).val);
        System.out.println(middleNode(QuestionUtils.buildLinkedList(new int[]{1, 2})).val);
        System.out.println(middleNode(QuestionUtils.buildLinkedList(new int[]{1, 2, 3, 4, 5})).val);
        System.out.println(middleNode(QuestionUtils.buildLinkedList(new int[]{1, 2, 3, 4, 5, 6})).val);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode middleNode(ListNode head) {
        ListNode mid = head, end = head;

        while (true) {

            if (end == null || end.next == null) {
                break;
            }

            mid = mid.next;
            end = end.next.next;


            if (end == null || end.next == null) {
                break;
            }
        }

        return mid;
    }
}
