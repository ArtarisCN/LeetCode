package util;

import java.util.List;

import model.ListNode;

/**
 * util
 * LeetCode
 * 2018.10.22.10:24
 *
 * @author : artairs
 */
public class PrintUtils {

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

    public static void printfArray(int[] array) {
        if (array != null) {
            for (int i : array) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void printfArray(char[] array) {
        if (array != null) {
            for (char i : array) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static <T> void printfArray(T[] array) {
        if (array != null) {
            for (T i : array) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void printf2DArray(int[][] result) {
        for (int[] aResult : result) {
            for (int anAResult : aResult) {
                System.out.print(anAResult + " ");
            }
            System.out.println();
        }
    }

    public static <T> void printfArrayList(List<T> array) {
        if (array != null) {
            for (T i : array) {
                System.out.println(i);
            }
        }
    }

}
