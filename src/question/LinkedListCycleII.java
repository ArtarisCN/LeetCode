package question;

import java.util.HashMap;
import java.util.Map;

import model.ListNode;

/**
 * question
 * LeetCode
 * 2019.08.12.17:34
 *
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * @author : artairs
 */
class LinkedListCycleII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node6;

        System.out.println(detectCycle(node1));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode detectCycle2(ListNode head){
        if(head == null){
            return null;
        }
        ListNode fast = head,slow = head,newNode = head;

        do {
            if(fast.next == null){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                while (slow != newNode){
                    newNode = newNode.next;
                    slow = slow.next;
                }
                return newNode;
            };
        }while (fast != null && slow != null);
        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode node = head;
        while (true) {
            if (node == null) {
                return null;
            }

            if(map.containsValue(node.next)){
                node = node.next;
                if (node.next == null) {
                    return null;
                } else if (node.next == head) {
                    return head;
                } else {
                    return node;
                }
            }
            map.put(node, node.next);
            node = node.next;
        }
    }

}
