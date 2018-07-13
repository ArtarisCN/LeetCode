package question;

import java.util.ArrayList;
import java.util.List;

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



        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        List<ListNode> result = new ArrayList<>();

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
