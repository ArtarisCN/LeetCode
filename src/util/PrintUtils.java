package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.LRUCache;
import model.ListNode;
import model.TreeNode;

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
    public static void printf(ListNode node) {
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

    public static void printf(int[] array) {
        if (array != null) {
            for (int i : array) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void printf(char[] array) {
        if (array != null) {
            for (char i : array) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static <T> void printf(T[] array) {
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

    public static void printfArrayList(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue1.add(root);
        while (true){
            boolean changed = false;
            while (!queue1.isEmpty()){
                changed = true;
                TreeNode node = queue1.poll();
                if(sb.length() == 0){
                    sb.append(node.getVal());
                } else {
                    sb.append(" -> ").append(node.getVal());
                }

                if(node.left !=null){
                    queue2.add(node.left);
                } else {
                    queue2.add(new TreeNode(-1));
                }
                if(node.right !=null){
                    queue2.add(node.right);
                } else {
                    queue2.add(new TreeNode(-1));
                }
            }

            while (!queue2.isEmpty()){
                changed = true;
                TreeNode node = queue2.poll();
                sb.append(" -> ").append(node.getVal());
                if(node.left !=null){
                    queue1.add(node.left);
                }
                if(node.right !=null){
                    queue1.add(node.right);
                }
            }
            if(!changed){
                break;
            }
        }

        System.out.println(sb.toString());
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
