package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.19.13:42
 * <p>
 * 100.Same Tree
 * https://leetcode.com/problems/same-tree/
 *
 * @author : artairs
 */
class SameTree {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(isSameTree(QuestionUtils.buildBinaryTree(new int[]{1, 2, 1}), QuestionUtils.buildBinaryTree(new int[]{1, 2, 1})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right) &&
                q.val == p.val;
    }
}
