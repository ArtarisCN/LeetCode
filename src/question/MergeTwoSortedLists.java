package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.07.12.0:18
 *
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * @author : artaris
 */
class MergeTwoSortedLists {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        PrintUtils.printf(
                mergeTwoLists(
                        QuestionUtils.buildLinkedList(new int[]{}),
                        QuestionUtils.buildLinkedList(new int[]{})
                )
        );

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp ,result;

        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            temp = l1;
            l1 = l1.next;
        } else {
            temp = l2;
            l2 = l2.next;
        }

        result = temp;


        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }


        if(l1 != null){
            temp.next = l1;
        }

        if(l2 != null){
            temp.next = l2;
        }

        return result;
    }
}
