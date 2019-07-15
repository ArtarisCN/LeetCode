package util;

import java.util.List;

import model.LRUCache;
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
            return;
        }

        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }

        System.out.println(node.val);
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
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void printCache(LRUCache cache) {
        System.out.println("-------");
        LRUCache.Entry node = cache.head;
        while (node != null){
            System.out.println(node.key + " " + node.value);
            node = node.next;
        }
    }

}
