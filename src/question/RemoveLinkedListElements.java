package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.07.20.下午3:33
 * <p>
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 *
 * @author : rick
 */
class RemoveLinkedListElements {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfLinkedList(removeElements(QuestionUtils.buildLinkedList(new int[]{}), 6));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode first = head, temp = first;


        while (head != null) {
            if (head.val == val) {
                temp.next = head.next;
            } else {
                temp = head;
            }
            head = head.next;
        }

        return first;
    }
}
