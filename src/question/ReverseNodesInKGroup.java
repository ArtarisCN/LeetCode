package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.20.10:41
 * <p>
 * 25. Reverse Nodes in k-Group
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author : artairs
 */
class ReverseNodesInKGroup {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfLinkedList(reverseKGroup(QuestionUtils.buildLinkedList(new int[]{1,2,3,4,5,6,7,8,9}),3));
        PrintUtils.printfLinkedList(reverseKGroup(QuestionUtils.buildLinkedList(new int[]{1,2}),3));
        PrintUtils.printfLinkedList(reverseKGroup(QuestionUtils.buildLinkedList(new int[]{1,2}),2));
        PrintUtils.printfLinkedList(reverseKGroup(QuestionUtils.buildLinkedList(new int[]{1}),2));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode preGroupFoot = dummyHead;
        ListNode groupHead = head;
        ListNode node = head;

        while (node != null) {
            int step = k;
            while (step-- > 0 && node != null) {
                node = node.next;
            }

            if(step >= 0){
                preGroupFoot.next = groupHead;
                break;
            }

            ListNode current = groupHead;
            ListNode temp, groupResult = null;

            while (current.next != node) {

                temp = groupResult;

                groupResult = current;

                current = current.next;

                groupResult.next = temp;
            }

            current.next = groupResult;
            groupResult = current;

            preGroupFoot.next = groupResult;
            preGroupFoot = groupHead;

            groupHead = node;
        }

        return dummyHead.next;
    }


}
