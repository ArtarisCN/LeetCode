package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.18.13:45
 *
 * 83.Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author : artairs
 */
class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        PrintUtils.printfLinkedList(deleteDuplicates(QuestionUtils.buildLinkedList(new int[]{1,1})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode thisNode = head;

        while (thisNode.next != null){
            if(thisNode.next.val > thisNode.val){
                thisNode = thisNode.next;
                continue;
            }

            if(thisNode.next.val == thisNode.val){
                thisNode.next = thisNode.next.next;
            }
        }

        return head;
    }
}
