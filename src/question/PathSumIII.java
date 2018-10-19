package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.18.16:32
 * <p>
 * 437.Path Sum III
 * https://leetcode.com/problems/path-sum-iii/
 *
 * @author : artairs
 */
class PathSumIII {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        System.out.println(pathSum(QuestionUtils.buildBinaryTree(new int[]{1,-2,-3,1,3,-2,0,-1}), -2));
//        System.out.println(pathSum(QuestionUtils.buildBinaryTree(new int[]{10,5,-3,3,2,0,11,3,-2,0,1}), 8));
        System.out.println(pathSum(QuestionUtils.buildBinaryTree(new int[]{1, -2, -3, 1, 3, -2, 0, -1}), -1));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, true);
    }
    public static int pathSum(TreeNode root, int sum, boolean isPath) {
        return (root == null?0:((root.val == sum ?1:0) +
                (isPath ? pathSum(root.left, sum, true) + pathSum(root.right, sum, true) : 0) +
                pathSum(root.left, sum - root.val, false) +
                pathSum(root.right, sum - root.val, false)));
    }

}
