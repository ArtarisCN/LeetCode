package question;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2018.07.20.下午4:50
 * <p>
 * 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * @author : rick
 */
class InvertBinaryTree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;

    }
}
