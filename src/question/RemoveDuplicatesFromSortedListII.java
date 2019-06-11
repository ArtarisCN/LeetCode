package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.11.09:50
 *
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author : artairs
 */
class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        PrintUtils.printfLinkedList(deleteDuplicates(QuestionUtils.buildLinkedList(new int[]{1,2,3,3,4,4,5})));
//        PrintUtils.printfLinkedList(deleteDuplicates(QuestionUtils.buildLinkedList(new int[]{1,1,1,2,3})));
        PrintUtils.printfLinkedList(deleteDuplicates(QuestionUtils.buildLinkedList(new int[]{1,1})));
//        PrintUtils.printfLinkedList(deleteDuplicates(QuestionUtils.buildLinkedList(new int[]{})));
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode preNode = dummyNode;
        ListNode node = head;
        ListNode nextNode = head.next;
        while (node != null){
            if(nextNode == null){
                break;
            }

            if(nextNode.val == node.val){
                while (nextNode != null && nextNode.val == node.val){
                    nextNode = nextNode.next;
                }

                preNode.next = nextNode;
                node = nextNode;
                if(node == null){
                    break;
                }
                nextNode = node.next;
                continue;
            }

            nextNode = nextNode.next;
            node = node.next;
            preNode = preNode.next;
        }

        return dummyNode.next;
    }

}
