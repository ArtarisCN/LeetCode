package question;

import model.ListNode;
import util.PrintUtils;

import static util.QuestionUtils.buildLinkedList;

/**
 * question
 * LeetCode
 * 2018.04.18.上午10:32
 * <p>
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * @author : rick
 */
class ReverseLinkedList {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printf(reverseList2(buildLinkedList(new int[]{1, 2, 3, 4, 5})));
        PrintUtils.printf(reverseList2(null));
        PrintUtils.printf(reverseList2(buildLinkedList(new int[]{1})));

//        reversePrintList(buildLinkedList(new int[]{1,2,3,4,5}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode now, pre = null;
        ListNode next = head;
        while (next.next != null) {
            now = pre;
            pre = next;
            next = next.next;
            pre.next = now;
        }
        next.next = pre;
        pre = next;
        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null,now = head, next;
        while (now != null) {
            next = now.next;//0
            now.next = pre;//1
            pre = now;//2
            now = next;//3
        }
        return pre;
    }

    public static void reversePrintList(ListNode head) {
        if (head.next != null)
            reversePrintList(head.next);
        System.out.println(head.val);
    }

}
