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
        return printfTree(t);
    }

    private static String printfTree(TreeNode t) {
        if (t == null) {
            return "";
        }

        if (t.left == null && t.right == null) {
            return String.valueOf(t.val);
        }

        if (t.left == null) {
            return String.valueOf(t.val) + "()(" + printfTree(t.right) + ")";
        }

        if (t.right == null) {
            return String.valueOf(t.val) + "(" + printfTree(t.left) + ")";
        }

        return String.valueOf(t.val) + "(" + printfTree(t.left) + ")(" + printfTree(t.right) + ")";
    }

}
