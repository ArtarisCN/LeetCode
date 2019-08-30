package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.10.20:36
 * <p>
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/
 *
 * @author : artairs
 */
class PartitionList {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        PrintUtils.printf(partition(QuestionUtils.buildLinkedList(new int[]{1,4,3,2,5,2}),3));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode less = null;
        ListNode more = null;

        ListNode lessNext = null;
        ListNode moreNext = null;

        ListNode node = head;
        while (node != null){
            if(node.val < x){
                if(less ==  null){
                    less = node;
                    lessNext = less;
                } else {
                    lessNext.next = node;
                    lessNext = node;
                }
            } else {
                if(more ==  null){
                    more = node;
                    moreNext = more;
                } else {
                    moreNext.next = node;
                    moreNext = node;
                }
            }

            node = node.next;
        }

        if(moreNext != null){
            moreNext.next = null;
        }

        ListNode result = null;

        if(less != null){
            result = less;
        }

        if(result != null){
            lessNext.next = more;
        } else {
            result = more;
        }

        return result;
    }
}
