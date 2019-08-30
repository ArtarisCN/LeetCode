package question;

import model.ListNode;

import static util.PrintUtils.printf;
import static util.QuestionUtils.buildLinkedList;

/**
 * question
 * LeetCode
 * 2018.04.18.上午10:44
 * <p>
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * @author : rick
 */
class ReverseLinkedListII {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        printf(reverseBetween(buildLinkedList(new int[]{1}), 1, 1));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {


        if (head == null || head.next == null || n - m == 0) {
            return head;
        }


        ListNode node = head;
        int i = 0;

        /**
         * 1: 前；
         * 2：中;
         * 3：后；
         *
         * 10：结束
         */
        int type = 1;

        ListNode result;

        ListNode firstStart = null, firstEnd = null;
        ListNode secondStart = null;
        ListNode thirdStart = null;


        while (node != null) {

            if (type == 10) {
                break;
            }

            i++;

            if (i == m - 1) {
                firstEnd = node;
            }

            if (i == m) {
                type = 2;
                secondStart = node;
                node = node.next;
                secondStart.next = null;
                continue;
            } else if (i == n) {
                type = 3;
                ListNode temp = node.next;
                node.next = secondStart;
                secondStart = node;
                node = temp;
                continue;
            }

            ListNode temp = null;
            switch (type) {
                case 1:
                    if (firstStart == null) {
                        firstStart = head;
                    }
                    break;
                case 2:
                    temp = secondStart;
                    secondStart = node;
                    break;
                case 3:
                    thirdStart = node;
                    type = 10;
                    break;
                default:
                    break;
            }

            node = node.next;
            if (type == 2) {
                secondStart.next = temp;
            }
        }

        if (firstStart != null) {
            result = firstStart;

            assert firstEnd != null;
            firstEnd.next = secondStart;

        } else {
            result = secondStart;
        }

        if (thirdStart != null) {
            node = secondStart;

            while (node.next != null) {
                node = node.next;
            }

            node.next = thirdStart;
        }

        return result;
    }
}
