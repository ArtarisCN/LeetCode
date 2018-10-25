package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.25.10:55
 *
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * @author : artairs
 */
class DiameterOfBinaryTree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        System.out.println(diameterOfBinaryTree(QuestionUtils.buildBinaryTree(new int[]{})));
//        System.out.println(diameterOfBinaryTree(QuestionUtils.buildBinaryTree(new int[]{1})));
//        System.out.println(diameterOfBinaryTree(QuestionUtils.buildBinaryTree(new int[]{1,2})));
//        System.out.println(diameterOfBinaryTree(QuestionUtils.buildBinaryTree(new int[]{1,2,0,1,2})));
//        System.out.println(diameterOfBinaryTree(QuestionUtils.buildBinaryTree(new int[]{1,2,3,4,5})));
//        System.out.println(diameterOfBinaryTree(QuestionUtils.buildBinaryTree(new int[]{1,2,3,4,5,6})));
        System.out.println(diameterOfBinaryTree(QuestionUtils.buildBinaryTree(new int[]{4,-7,-3,0,0,-9,-3,9,-7,-4,0,6,0,-6,-6,0,0,0,6,5,0,9,0,0,-1,-4,0,0,0,-2})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if(root.left == null && root.right == null){
            return 0;
        }

        if (root.left == null) {
            return Math.max(diameterOfBinaryTree(root.right),deep(root.right) + 1);
        }

        if (root.right == null) {
            return Math.max(diameterOfBinaryTree(root.left),deep(root.left) + 1);
        }

        return Math.max(Math.max(deep(root.right) + deep(root.left) + 2,diameterOfBinaryTree(root.left)),diameterOfBinaryTree(root.right));
    }

    private static int deep(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return 0;
        }

        return Math.max(deep(root.left), deep(root.right)) + 1;
    }

}
