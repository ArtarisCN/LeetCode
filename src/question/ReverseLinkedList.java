package question;

import model.ListNode;

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

//        PrintUtils.printfLinkedList(reverseList(buildLinkedList(new int[]{1,2,3,4,5})));

        reversePrintList(buildLinkedList(new int[]{1,2,3,4,5}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp, result = null;

        ListNode x = head;

        while (x.next != null) {

            temp = result;

            result = x;

            x = x.next;

            result.next = temp;

        }

        x.next = result;
        result = x;


        return result;
    }

    public static void reversePrintList(ListNode head) {
        if (head.next != null)
            reversePrintList(head.next);
        System.out.println(head.val);
    }

}
