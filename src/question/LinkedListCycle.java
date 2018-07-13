package question;

import model.ListNode;

/**
 * question
 * LeetCode
 * 2018.07.13.上午10:36
 *
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 *
 * @author : rick
 */
class LinkedListCycle {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode node1 = head,node2 = head.next;

        if(head.next == head){
            return true;
        }

        while (node1 != null && node2 != null){
            if(node1 == node2){
                return true;
            }
            node1 = node1.next;

            if(node2.next == null){
                break;
            } else {
                node2 = node2.next.next;
            }
        }

        return false;
    }
}
