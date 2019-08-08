package question;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;
import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2019.08.08.14:20
 * <p>
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 *
 * @author : artairs
 */
class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        List<TreeNode> result = generateTrees(1);
        for (TreeNode treeNode : result) {
            PrintUtils.printfArrayList(treeNode);
        }

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return generateTree(1,n);
    }

    public static List<TreeNode> generateTree(int start, int end) {
        if (start > end) {
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTree(start, i - 1);
            List<TreeNode> right = generateTree(i + 1, end);
            if(left != null){
                for (TreeNode treeNode : left) {
                    if(right != null){
                        for (TreeNode node : right) {
                            TreeNode root = new TreeNode(i);
                            root.left = treeNode;
                            root.right = node;
                            result.add(root);
                        }
                    } else {
                        TreeNode root = new TreeNode(i);
                        root.left = treeNode;
                        result.add(root);
                    }
                }
            } else {
                if(right != null){
                    for (TreeNode node : right) {
                        TreeNode root = new TreeNode(i);
                        root.right = node;
                        result.add(root);
                    }
                } else {
                    TreeNode root = new TreeNode(i);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
