package question;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.10.21:08
 * <p>
 * 328. Odd Even Linked List
 * https://leetcode.com/problems/odd-even-linked-list/
 *
 * @author : artairs
 */
class OddEvenLinkedList {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        PrintUtils.printfLinkedList(oddEvenList(QuestionUtils.buildLinkedList(new int[]{1,2,3,4,5})));
        PrintUtils.printf(oddEvenList(QuestionUtils.buildLinkedList(new int[]{1})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = null;
        ListNode even = null;

        ListNode oddHead = null;
        ListNode evenHead = null;

        ListNode node = head;
        boolean isOdd = true;
        while (node != null) {
            if (isOdd) {
                if(oddHead == null){
                    oddHead = node;
                    odd = oddHead;
                } else {
                    odd.next = node;
                    odd = odd.next;
                }
            } else {
                if(evenHead == null){
                    evenHead = node;
                    even = evenHead;
                } else {
                    even.next = node;
                    even = even.next;
                }
            }

            isOdd = !isOdd;
            node = node.next;
        }

        if(oddHead == null){
            return null;
        }

        if(even != null) {
            even.next = null;
        }

        odd.next = evenHead;

        return oddHead;
    }

}
