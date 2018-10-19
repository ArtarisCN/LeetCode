package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.19.11:44
 * <p>
 * 101.Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 *
 * @author : artairs
 */
class SymmetricTree {


    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(isSymmetric(QuestionUtils.buildBinaryTree(new int[]{1, 3, 3, 3, 0, 0, 4})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null || root.right == null && root.left == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        return isMirror(root.left, root.right);

    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return isMirror(left.right, right.left) && isMirror(left.left, right.right) && left.val == right.val;

    }
}
