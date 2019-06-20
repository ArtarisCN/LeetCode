package question;

import java.util.HashMap;
import java.util.Map;

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

        BalancedBinaryTree tree = new BalancedBinaryTree();

        System.out.println(tree.isBalanced3(QuestionUtils.buildBinaryTree(new int[]{3, 9, 20, 0, 0, 15, 7})));
        BalancedBinaryTree tree1 = new BalancedBinaryTree();
        System.out.println(tree1.isBalanced3(QuestionUtils.buildBinaryTree(new int[]{1,
                2, 2,
                3, 3, 0, 0, 4, 4})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       方法一                        =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

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

    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       方法二                        =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

    public static boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        Map<TreeNode,Integer> map = new HashMap<>();
        return Math.abs(calculateHeight1(root.left,map) - calculateHeight1(root.right,map)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    public static int calculateHeight1(TreeNode treeNode, Map<TreeNode,Integer> map) {
        if (treeNode == null) {
            return 0;
        }

        if(map.containsKey(treeNode)){
            return map.get(treeNode);
        }

        if (treeNode.right == null && treeNode.left == null) {
            return 1;
        }

        int height = Math.max(calculateHeight1(treeNode.left,map), calculateHeight1(treeNode.right,map)) + 1;
        map.put(treeNode,height);

        return height;
    }

    //                  =======================================================
    //                  =                                                     =
    //                  =                                                     =
    //                  =                       方法三                        =
    //                  =                                                     =
    //                  =                                                     =
    //                  =======================================================

    Map<TreeNode,Integer> map = new HashMap<>();
    public boolean isBalanced3(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(calculateHeight3(root.left) - calculateHeight3(root.right)) <= 1 && isBalanced3(root.left) && isBalanced3(root.right);
    }

    public int calculateHeight3(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        if(map.containsKey(treeNode)){
            return map.get(treeNode);
        }

        if (treeNode.right == null && treeNode.left == null) {
            return 1;
        }

        int height = Math.max(calculateHeight3(treeNode.left), calculateHeight3(treeNode.right)) + 1;
        map.put(treeNode,height);

        return height;
    }

}
