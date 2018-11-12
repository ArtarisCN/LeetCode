package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.11.12.14:52
 * <p>
 * 897. Increasing Order Search Tree
 * https://leetcode.com/problems/increasing-order-search-tree/
 *
 * @author : artairs
 */
class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        TreeNode result = increasingBST(QuestionUtils.buildBinaryTree(new int[]{5,
                3, 6,
                2, 4, 0, 8,
                1, 0, 0, 0, 0, 0, 7, 9}));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode result = root;

        if (root.right != null) {
            root.right = increasingBST(root.right);
        }

        if (root.left != null) {
            result = increasingBST(root.left);
            root.left = null;
            TreeNode left = result;
            while (left.right != null) {
                left = left.right;
            }

            left.right = root;
        }

        return result;
    }
}
