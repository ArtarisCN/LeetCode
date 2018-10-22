package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import model.ListNode;
import model.TreeNode;

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

    public static TreeNode buildBinaryTree(int[] array){
        if(array.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        for (int i = 1; i < array.length; i++) {
            if(array[i] == 0){
                list.add(null);
                continue;
            } else {
                if(i % 2 == 1){
                    TreeNode node = new TreeNode(array[i]);
                    TreeNode link = list.get((i - 1)/2);
                    link.left = node;
                    list.add(node);
                } else {
                    TreeNode node = new TreeNode(array[i]);
                    TreeNode link = list.get((i - 2)/2);
                    link.right = node;
                    list.add(node);
                }
            }
        }

        return root;
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
