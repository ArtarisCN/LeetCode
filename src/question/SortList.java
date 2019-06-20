package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.20.11:45
 *
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 *
 * @author : artairs
 */
class SortList {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfLinkedList(sortList(QuestionUtils.buildLinkedList(new int[]{4,2,1,3})));
        PrintUtils.printfLinkedList(sortList(QuestionUtils.buildLinkedList(new int[]{5,4,2,1,6,3})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head,slow = head,preSlow = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }

        preSlow.next = null;

        head = sortList(head);
        slow = sortList(slow);
        return mergeList(head,slow);
    }

    public static ListNode mergeList(ListNode node1,ListNode node2){
        ListNode result = new ListNode(0);
        ListNode node = result;

        while (node1 != null && node2 != null){
            if(node1.val > node2.val){
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }

        if(node1 != null){
            node.next = node1;
        } else {
            node.next = node2;
        }


        return result.next;
    }

}
