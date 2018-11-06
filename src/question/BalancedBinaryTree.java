package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.11.06.12:42
 *
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * @author : artairs
 */
class BalancedBinaryTree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        System.out.println(isBalanced(QuestionUtils.buildBinaryTree(new int[]{3, 9, 20, 0, 0, 15, 7})));
        System.out.println(isBalanced(QuestionUtils.buildBinaryTree(new int[]{1,
                2, 2,
                3, 3, 0, 0, 4, 4})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int calculateHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        if (treeNode.right == null && treeNode.left == null) {
            return 1;
        }

        return Math.max(calculateHeight(treeNode.left), calculateHeight(treeNode.right)) + 1;
    }

}
