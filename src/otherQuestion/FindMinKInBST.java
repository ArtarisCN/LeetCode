package otherQuestion;

import model.TreeNode;

/**
 * otherQuestion
 * LeetCode
 * 2019.07.15.16:10
 *
 * @author : artairs
 */
class FindMinKInBST {
    static TreeNode find(TreeNode node, int K) {
        int leftTreeLength = getLength(node);
        if (leftTreeLength >= K) {
            return find(node.left, K);
        } else if (leftTreeLength == K + 1) {
            return node;
        } else {
            return find(node.left, K - leftTreeLength - 1);
        }
    }

    static int getLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return (node.left == null ? 0 : getLength(node.left)) + (node.right == null ? 0 : getLength(node.right)) + 1;
    }

    private class ResultType {

        boolean found;  // 是否找到

        int val;  // 节点数目
        ResultType(boolean found, int val) {
            this.found = found;
            this.val = val;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k).val;
    }

    private ResultType kthSmallestHelper(TreeNode root, int k) {
        if (root == null) {
            return new ResultType(false, 0);
        }

        ResultType left = kthSmallestHelper(root.left, k);

        // 左子树找到，直接返回
        if (left.found) {
            return new ResultType(true, left.val);
        }

        // 左子树的节点数目 = K-1，结果为 root 的值
        if (k - left.val == 1) {
            return new ResultType(true, root.val);
        }

        // 右子树寻找
        ResultType right = kthSmallestHelper(root.right, k - left.val - 1);
        if (right.found) {
            return new ResultType(true, right.val);
        }

        // 没找到，返回节点总数
        return new ResultType(false, left.val + 1 + right.val);
    }

}
