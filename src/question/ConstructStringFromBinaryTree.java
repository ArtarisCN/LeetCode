package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.11.05.18:37
 * <p>
 * 606. Construct String from Binary Tree
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 *
 * @author : artairs
 */
class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(tree2str(QuestionUtils.buildBinaryTree(new int[]{1, 2, 3, 4})));
        System.out.println(tree2str(QuestionUtils.buildBinaryTree(new int[]{1, 2, 3, 0, 4})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static String tree2str(TreeNode t) {
        return printfTree(t).toString();
    }

    private static StringBuilder printfTree(TreeNode t) {
        if (t == null) {
            return new StringBuilder();
        }

        if (t.left == null && t.right == null) {
            return new StringBuilder(String.valueOf(t.val));
        }

        if (t.left == null) {
            return new StringBuilder(String.valueOf(t.val)).append("()(").append(printfTree(t.right)).append(")");
        }

        if (t.right == null) {
            return new StringBuilder(String.valueOf(t.val)).append("(").append(printfTree(t.left)).append(")");
        }
        return new StringBuilder(String.valueOf(t.val)).append("(").append(printfTree(t.left)).append(")(").append(printfTree(t.right)).append(")");
    }

}
