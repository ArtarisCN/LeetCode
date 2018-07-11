package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import model.ListNode;

/**
 * util
 * LeetCode
 * 2018.04.19.上午10:01
 *
 * @author : rick
 */
public class QuestionUtils {

    /**
     * 由数组创建链表
     *
     * @param array
     * @return
     */
    public static ListNode buildLinkedList(int[] array) {
        if(array.length == 0)
            return null;

        ListNode head = new ListNode(array[0]);
        ListNode node = head;

        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }

        return head;
    }



    /**
     * 打印链表
     *
     * @param node
     */
    public static void printfLinkedList(ListNode node) {
        if (node == null) {
            System.out.println("null");
        }

        while (node != null) {

            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 获取int 型长度
     * @param x
     * @return
     */
    public static int getIntegerLength(int x) {
        int v = Math.abs(x);
        if (v == 0) {
            return 0;
        }
        BigDecimal r = new BigDecimal((Math.log(v) / Math.log(10)));
        int i = r.setScale(0, RoundingMode.HALF_UP).intValue();
        return i + 1;
    }
}
