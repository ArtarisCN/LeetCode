package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.24.11:01
 *
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * @author : artairs
 */
class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(isSubtree(
                QuestionUtils.buildBinaryTree(new int[]{3, 4, 5, 1, 2}),
                QuestionUtils.buildBinaryTree(new int[]{4, 1, 3})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }

        if (s == null) {
            return false;
        }

        if (s.val == t.val) {
            if (judge(s, t)) {
                return true;
            }
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static boolean judge(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }

        if (t == null || s == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return judge(s.left, t.left) && judge(s.right, t.right);
    }
}
