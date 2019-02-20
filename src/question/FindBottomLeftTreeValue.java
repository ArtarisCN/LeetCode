package question;

import java.util.LinkedList;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2019.02.20.14:51
 * <p>
 * 513. Find Bottom Left Tree Value
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 *
 * @author : artairs
 */
class FindBottomLeftTreeValue {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        System.out.println(findBottomLeftValue(QuestionUtils.buildBinaryTree(new int[]{1,2,3,4,0,5,6,0,0,0,0,7})));
        System.out.println(findBottomLeftValue(QuestionUtils.buildBinaryTree(new int[]{2, 1, 3})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int findBottomLeftValue(TreeNode root) {
        TreeNode result = null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            result = queue.element();

            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result.val;
    }


}
