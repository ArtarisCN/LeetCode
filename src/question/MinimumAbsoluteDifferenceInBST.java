package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.11.06.19:33
 *
 * 530. Minimum Absolute Difference in BST
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * @author : artairs
 */
class MinimumAbsoluteDifferenceInBST {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(getMinimumDifference(QuestionUtils.buildBinaryTree(new int[]{236,104,701,0,227,0,911})));
        System.out.println(getMinimumDifference(QuestionUtils.buildBinaryTree(new int[]{600,424,612,0,499,0,689})));


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int getMinimumDifference(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }

        if(root.left == null && root.right == null){
            return Integer.MAX_VALUE;
        }

        if(root.right == null){
            return Math.min(Math.abs(root.val - findLeft(root.left)),getMinimumDifference(root.left));
        }

        if(root.left == null){
            return Math.min(Math.abs(root.val - findRight(root.right)),getMinimumDifference(root.right));
        }


        return Math.min(Math.min(getMinimumDifference(root.left)
                ,getMinimumDifference(root.right)),
                Math.min(Math.abs(root.val - findLeft(root.left)),
                        Math.abs(root.val - findRight(root.right))));
    }

    private static int findLeft(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.right == null && root.left == null){
            return root.val;
        }

        if(root.right == null){
            return root.val;
        }

        return findLeft(root.right);
    }

    private static int findRight(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.right == null && root.left == null){
            return root.val;
        }

        if(root.left == null){
            return root.val;
        }

        return findRight(root.left);
    }

}
