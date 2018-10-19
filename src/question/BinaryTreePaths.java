package question;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.19.16:38
 * <p>
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * @author : artairs
 */
class BinaryTreePaths {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<String> result = binaryTreePaths(QuestionUtils.buildBinaryTree(new int[]{1, 2}));

        for (String s : result) {
            System.out.println(s);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }

        if (root.left != null) {
            binaryTreePaths(root.left, String.valueOf(root.val), result);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, String.valueOf(root.val), result);
        }
        return result;

    }


    public static void binaryTreePaths(TreeNode node, String s, List<String> result) {
        if (node.right != null) {
            binaryTreePaths(node.right, s + "->" + node.val, result);
        }

        if (node.left != null) {
            binaryTreePaths(node.left, s + "->" + node.val, result);
        }

        if (node.right == null && node.left == null) {
            result.add(s + "->" + node.val);
        }
    }

}
