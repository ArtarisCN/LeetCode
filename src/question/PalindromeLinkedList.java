package question;

import model.ListNode;

/**
 * question
 * LeetCode
 * 2018.04.17.下午5:37
 * <p>
 * https://leetcode.com/problems/palindrome-linked-list/description/
 *
 * @author : rick
 */
class PalindromeLinkedList {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        int[] x = {1, 0, 0};

        System.out.println(isPalindrome(buildLinkedList(x)));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first, second;
        boolean sign = false;

        second = slow.next;

        if (fast.next == null) {
            sign = true;
        }

        ListNode node, temp;
        first = head;

        if (first != slow) {
            node = head.next;
            first.next = null;

            while (node != slow) {
                temp = node;
                node = node.next;
                temp.next = first;
                first = temp;
            }

            slow.next = first;
            first = slow;
        }


        if (sign) {
            first = first.next;
        }


        while (first.next != null && second.next != null) {
            if (first.val != second.val) {
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return first.val == second.val;
    }

    public static boolean isPalindromeWraong(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        long sum = 0;

        int index = 10;

        ListNode node, temp;

        node = head.next;
        head.next = null;

        sum += index * head.val;

        while (node.next != null) {

            index++;

            temp = node;
            node = node.next;
            temp.next = head;
            head = temp;


            sum += index * head.val;
        }

        node.next = head;
        head = node;

        index++;
        sum += index * head.val;

        node = head.next;
        index = 10;

        sum -= index * head.val;

        while (node.next != null) {

            index++;
            sum -= index * node.val;
            node = node.next;
        }

        index++;
        sum -= index * node.val;

        return sum == 0;
    }

    private static ListNode buildLinkedList(int[] array) {
        ListNode head = new ListNode(array[0]);
        ListNode node = head;

        for (int i = 1; i < array.length; i++) {
            ListNode temp = new ListNode(array[i]);

            node.next = temp;
            node = node.next;
        }

        return head;
    }
}
