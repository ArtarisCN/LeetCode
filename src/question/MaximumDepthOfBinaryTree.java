package question;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2018.07.31.0:03
 *
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * @author : artaris
 */
class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println(maxDepth(root));

        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int maxDepth(TreeNode root) {

        return getMaxDepth(root,1);

    }

    public static int getMaxDepth(TreeNode node,int depth){

        if(node == null){
            return depth - 1;
        }

        return Math.max(getMaxDepth(node.left,depth + 1),getMaxDepth(node.right,depth + 1));

    }

}
