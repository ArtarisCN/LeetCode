package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2019.07.04.14:28
 *
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * @author : artairs
 */
class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }

    /**
     * 方法二，使用非递归方法，模拟一个栈
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Command> commands = new Stack<>();
        commands.add(new Command(true, root));
        while (!commands.empty()) {
            Command command = commands.pop();
            if (command.isPoped) {
                commands.add(new Command(false, command.node));
                if (command.node.right != null) {
                    commands.add(new Command(true, command.node.right));
                }
                if (command.node.left != null) {
                    commands.add(new Command(true, command.node.left));
                }
            } else {
                result.add(command.node.val);
            }
        }

        return result;
    }

    private class Command {
        boolean isPoped;
        TreeNode node;

        public Command(boolean isPoped, TreeNode node) {
            this.isPoped = isPoped;
            this.node = node;
        }
    }

}
