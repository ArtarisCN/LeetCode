package question;

import java.util.ArrayList;
import java.util.List;

import model.ListNode;
import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.06.20.09:37
 * <p>
 * 109. Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @author : artairs
 */
class ConvertSortedList2BinarySearchTree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        TreeNode node = sortedListToBST2(QuestionUtils.buildLinkedList(new int[]{-10, -3, 0, 5, 9}));

        System.out.println(node.val);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode fast = head, slow = head;
        ListNode preSlow = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);

        if (preSlow != null) {
            preSlow.next = null;
        }

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }

    public static TreeNode sortedListToBST2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return sortedArrayToBST(list);
    }

    public static TreeNode sortedArrayToBST(List<Integer> nums) {
        if (nums.size() == 0) {
            return null;
        }
        int element = nums.get(nums.size() / 2);
        TreeNode root = new TreeNode(element);
        root.left = buildTree(nums, 0, nums.size() / 2 - 1);
        root.right = buildTree(nums, nums.size() / 2 + 1, nums.size() - 1);
        return root;
    }


    public static TreeNode buildTree(List<Integer> nums, int start, int end) {
        if (end - start >= 3) {
            int element = nums.get((start + end) / 2);
            TreeNode root = new TreeNode(element);
            root.left = buildTree(nums, start, (start + end) / 2 - 1);
            root.right = buildTree(nums, (start + end) / 2 + 1, end);
            return root;
        } else if (end - start == 2) {
            TreeNode root = new TreeNode(nums.get((start + end) / 2));
            root.left = new TreeNode(nums.get(start));
            root.right = new TreeNode(nums.get(end));
            return root;
        } else if (end - start == 1) {
            TreeNode root = new TreeNode(nums.get((start + end) / 2));
            root.right = new TreeNode(nums.get(end));
            return root;
        } else if (end < start) {
            return null;
        } else {
            return new TreeNode(nums.get((start + end) / 2));
        }
    }

}
