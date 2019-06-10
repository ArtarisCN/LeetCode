package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.11.00:52
 *
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 *
 * @author : artairs
 */
class ReorderList {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        ListNode node = QuestionUtils.buildLinkedList(new int[]{1});
        reorderList(node);
        PrintUtils.printfLinkedList(node);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        ListNode first = head;
        ListNode second = head;
        ListNode preFirst = head;

        while (second != null){
            second = second.next;
            if(second == null){
                break;
            }
            preFirst = first;
            first = first.next;
            second = second.next;
        }

        preFirst.next = null;
        ListNode result = null;
        second = reverseList(first);
        first = head;

        if(first == second){
            return;
        }

        ListNode node = null;
        while (first != null && second != null){

            if(node == null){
                node = first;
                result = node;
            } else {
                node.next = first;
                node = node.next;
            }

            first = first.next;

            node.next = second;
            second = second.next;
            node = node.next;
        }

        if(second != null){
            node.next = second;
        }

        head = result;
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
}
