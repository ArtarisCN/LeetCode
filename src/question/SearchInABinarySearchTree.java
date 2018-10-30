package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.30.14:57
 *
 * 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * @author : artairs
 */
class SearchInABinarySearchTree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(searchBST(QuestionUtils.buildBinaryTree(new int[]{4,2,7,1,3}),5));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        TreeNode node = root;

        while (node.val != val){
            if(node.val < val){
                if(node.right == null){
                    return null;
                } else {
                    node = node.right;
                }
            } else {
                if(node.left == null){
                    return null;
                } else {
                    node = node.left;
                }
            }
        }
        return node;
    }
}
