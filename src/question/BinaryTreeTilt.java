package question;

import java.util.Objects;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.24.13:34
 *
 * 563. Binary Tree Tilt
 * https://leetcode.com/problems/binary-tree-tilt/
 *
 * @author : artairs
 */
class BinaryTreeTilt {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(findTilt(Objects.requireNonNull(QuestionUtils.buildBinaryTree(new int[]{1,2,3,4,0,5}))));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findTilt(TreeNode root) {
        if (root == null){
            return 0;
        }

        if(root.left == null && root.right == null ){
            return 0;
        }

        if(root.left == null){
            return findTilt(root.right) + Math.abs(0 - sum(root.right));
        }

        if(root.right == null){
            return findTilt(root.left)+ Math.abs(0 - sum(root.left));
        }

        return findTilt(root.left) + findTilt(root.right) + Math.abs(sum(root.left) - sum(root.right));
    }

    private static int sum(TreeNode root){
        if(root == null){
            return 0;
        }

        return sum(root.right) + sum(root.left) + root.val;
    }
}
