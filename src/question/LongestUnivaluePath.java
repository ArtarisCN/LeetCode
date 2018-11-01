package question;

import model.TreeNode;
import util.QuestionUtils;

/**
 * question
 * LeetCode
 * 2018.10.31.16:14
 * <p>
 * 687. Longest Univalue Path
 * https://leetcode.com/problems/longest-univalue-path/
 *
 * @author : artairs
 */
class LongestUnivaluePath {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        System.out.println(longestUnivaluePath(QuestionUtils.buildBinaryTree(new int[]{5, 4, 5, 1, 1, 0, 5})));
        System.out.println(longestUnivaluePath(QuestionUtils.buildBinaryTree(new int[]{1, 4, 5, 4, 4, 0, 5})));
        System.out.println(longestUnivaluePath(QuestionUtils.buildBinaryTree(new int[]{
                -6,
                8, -4,
                8, -5, -1, 0,
                -9, 9, 8, 8, 0, 0, 0, 0,
                -5, 6, 0, 0, 0, -4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -9})));

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        if (root.left == null) {
            if (root.val == root.right.val) {
                return Math.max(longestUnivaluePath(root.right), longestUnivaluePathWithValue(root.right, root.val, 1));
            } else {
                return longestUnivaluePath(root.right);
            }
        }

        if (root.right == null) {
            if (root.val == root.left.val) {
                return Math.max(longestUnivaluePath(root.left), longestUnivaluePathWithValue(root.left, root.val, 1));
            } else {
                return longestUnivaluePath(root.left);
            }
        }

        if (root.left.val == root.val && root.val == root.right.val) {
            return Math.max(longestUnivaluePathWithValue(root.left, root.val,
                    longestUnivaluePathWithValue(root.right, root.val, 0)) + 2,
                    Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
        }

        if (root.left.val == root.val) {
            return Math.max(Math.max(longestUnivaluePathWithValue(root.left, root.val, 1), longestUnivaluePath(root.left)), longestUnivaluePath(root.right));
        }

        if (root.right.val == root.val) {
            return Math.max(Math.max(longestUnivaluePathWithValue(root.right, root.val, 1), longestUnivaluePath(root.right)), longestUnivaluePath(root.left));
        }

        return Math.max(longestUnivaluePath(root.right), longestUnivaluePath(root.left));
    }

    public static int longestUnivaluePathWithValue(TreeNode root, int value, int result) {
        if (root == null || root.val != value) {
            return result;
        }

        if (root.left == null && root.right == null) {
            return result;
        }

        if (root.left == null) {
            if (root.right.val == value) {
                return longestUnivaluePathWithValue(root.right, value, result + 1);
            }
            return result;
        }

        if (root.right == null) {
            if (root.left.val == value) {
                return longestUnivaluePathWithValue(root.left, value, result + 1);
            }
            return result;
        }

        return Math.max(longestUnivaluePathWithValue(root.left, value, result ), longestUnivaluePathWithValue(root.right, value, result ));
    }
}
