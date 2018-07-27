package question;

import model.ListNode;

/**
 * question
 * LeetCode
 * 2018.07.20.下午6:40
 *
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 *
 * @author : rick
 */
class DeleteNodeInALinkedList {

    public static ListNode head;

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static void deleteNode(ListNode node) {

        if(head.val == node.val){
            head = head.next;
            return;
        }

        ListNode currentNode = head.next,preNode = head;

        while (currentNode != null){
            if(currentNode.val == node.val){
                preNode.next = currentNode.next;
                return;
            }
            currentNode = currentNode.next;
        }

    }

}
