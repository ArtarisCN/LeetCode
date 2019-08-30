package question;

import java.util.HashSet;
import java.util.Set;

import model.ListNode;

/**
 * question
 * LeetCode
 * 2018.07.13.上午10:25
 *
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 *
 * @author : rick
 */
class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        ListNode node41 = new ListNode(4);
        ListNode node11 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        ListNode node51 = new ListNode(5);
        ListNode node0 = new ListNode(0);
        ListNode node12 = new ListNode(1);

        node41.next = node11;
        node11.next= node8;
        node8.next = node4;
        node4.next = node5;

        node51.next = node0;
        node0.next = node12;
        node12.next = node8;

        System.out.println(getIntersectionNode1(node41,node51));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = 0, lengthB = 0;
        ListNode cura = headA, curB = headB;
        while (cura != null) {
            lengthA++;
            cura = cura.next;
        }
        while (curB != null) {
            lengthB++;
            curB = curB.next;
        }
        ListNode first = headA, second = headB;
        int step = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            for (int i = 0; i < step; i++) {
                first = first.next;
            }
        } else {
            for (int i = 0; i < step; i++) {
                second = second.next;
            }
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> result = new HashSet<>();
        while (headA != null){
            result.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(result.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
