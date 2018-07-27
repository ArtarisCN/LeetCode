package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2018.07.27.下午2:31
 * <p>
 * 872. Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * @author : rick
 */
class LeafSimilarTrees {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        List<TreeNode> list1 = new ArrayList<>(), list2 = new ArrayList<>();

        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.empty()) {

            TreeNode node = stack1.pop();

            if (node.left == null && node.right == null) {
                list1.add(node);
                continue;
            }

            if (node.right != null) {
                stack1.push(node.right);
            }

            if (node.left != null) {
                stack1.push(node.left);
            }

        }

        while (!stack2.empty()) {

            TreeNode node = stack2.pop();

            if (node.left == null && node.right == null) {
                list2.add(node);
                continue;
            }

            if (node.right != null) {
                stack2.push(node.right);
            }

            if (node.left != null) {
                stack2.push(node.left);
            }
        }

        boolean isSimilar = true;

        for (int i = 0; i < list1.size(); i++) {
            TreeNode treeNode1 = list1.get(i);
            TreeNode treeNode2 = list2.get(i);

            if (treeNode1 == null || treeNode2 == null || treeNode1.val != treeNode2.val) {
                isSimilar = false;
                break;
            }
        }

        return isSimilar;
    }
}
