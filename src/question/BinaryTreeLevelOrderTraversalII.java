package question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.11.06.10:24
 * <p>
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author : artairs
 */
class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<List<Integer>> result = levelOrderBottom(QuestionUtils.buildBinaryTree(new int[]{3, 9, 20, 0, 0, 15, 7}));
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();

        temp.add(root.val);
        result.add(temp);
        levelOrder(result, root.left, 1);
        levelOrder(result, root.right, 1);
        return result;
    }


    public static void levelOrder(LinkedList<List<Integer>> result, TreeNode root, int index) {
        if (root == null) {
            return;
        }

        if (result.size() < (index + 1)) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.addFirst(temp);
            levelOrder(result, root.left, index + 1);
            levelOrder(result, root.right, index + 1);
        } else {
            List<Integer> temp = result.get(result.size() - index - 1);
            temp.add(root.val);
            levelOrder(result, root.left, index + 1);
            levelOrder(result, root.right, index + 1);
        }
    }


}
