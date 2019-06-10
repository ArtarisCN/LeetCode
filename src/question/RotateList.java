package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.11.00:25
 *
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 *
 * @author : artairs
 */
class RotateList {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfLinkedList(rotateRight(QuestionUtils.buildLinkedList(new int[]{0,1,2}),4));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static ListNode rotateRight(ListNode head, int k) {

        if(head == null){
            return null;
        }

        int length = 0;
        ListNode node = head;
        while (node != null){
            node = node.next;
            length ++;
        }

        k = k % length;
        if(k == 0){
            return head;
        }

        ListNode startNode = head;
        ListNode endNode = startNode;
        ListNode preEndNode = null;
        int i = k + 1;
        while (i > 0 && endNode != null) {
            preEndNode = endNode;
            endNode = endNode.next;

            i--;
        }

        while (endNode != null){
            startNode = startNode.next;
            preEndNode = endNode;
            endNode = endNode.next;
        }


        ListNode result = startNode.next;
        preEndNode.next = head;
        startNode.next = null;

        return result;
    }

}
