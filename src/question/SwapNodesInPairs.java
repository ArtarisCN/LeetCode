package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.11.00:13
 * <p>
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * @author : artairs
 */
class SwapNodesInPairs {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        PrintUtils.printfLinkedList(swapPairs(QuestionUtils.buildLinkedList(new int[]{1,2,3,4,5,6})));
        PrintUtils.printf(swapPairs(QuestionUtils.buildLinkedList(new int[]{1})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode beforeFirst = dummyNode;
        ListNode first = head;
        ListNode second = head.next;

        while (first != null && second != null) {

            beforeFirst.next = second;
            first.next = second.next;
            second.next = first;

            beforeFirst = first;
            first = first.next;
            if(first == null){
                break;
            }
            second = first.next;
        }

        return dummyNode.next;
    }


}
