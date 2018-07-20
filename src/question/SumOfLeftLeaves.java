package question;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2018.07.20.上午11:47
 *
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * @author : rick
 */
class SumOfLeftLeaves {

    public static void main(String[] args) {


        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public static int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return sumOfLeftLeaves(root.right);
        }

        if (root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        ;

    }
}
