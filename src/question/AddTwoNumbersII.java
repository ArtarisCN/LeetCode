package question;

import java.util.Stack;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.11.10:52
 * <p>
 * 445. Add Two Numbers II
 * https://leetcode.com/problems/add-two-numbers-ii/
 *
 * @author : artairs
 */
class AddTwoNumbersII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        PrintUtils.printfLinkedList(addTwoNumbers(
//                QuestionUtils.buildLinkedList(new int[]{7, 2, 4, 3}),
//                QuestionUtils.buildLinkedList(new int[]{5, 6, 4})
//        ));

        PrintUtils.printf(addTwoNumbers(
                QuestionUtils.buildLinkedList(new int[]{1}),
                QuestionUtils.buildLinkedList(new int[]{9,9})
        ));


        PrintUtils.printf(addTwoNumbers(
                QuestionUtils.buildLinkedList(new int[]{}),
                QuestionUtils.buildLinkedList(new int[]{})
        ));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        ListNode node = null;
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();

            node1.val = node1.val + node2.val + carry;
            carry = node1.val >= 10 ? 1 : 0;
            node1.val %= 10;

            node1.next = node;
            node = node1;
        }

        if (stack1.isEmpty() && !stack2.isEmpty()) {
            while (!stack2.isEmpty()) {
                ListNode node2 = stack2.pop();

                node2.val = node2.val + carry;
                carry = node2.val >= 10 ? 1 : 0;
                node2.val %= 10;

                node2.next = node;
                node = node2;
            }
        } else if (stack2.isEmpty() && !stack1.isEmpty()) {
            while (!stack1.isEmpty()) {
                ListNode node1 = stack1.pop();

                node1.val = node1.val + carry;
                carry = node1.val >= 10 ? 1 : 0;
                node1.val %= 10;

                node1.next = node;
                node = node1;
            }
        }

        if (carry > 0) {
            ListNode result = new ListNode(carry);
            result.next = node;
            node = result;
        }

        return node;
    }

}
