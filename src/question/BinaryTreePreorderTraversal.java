package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2019.07.04.12:02
 *
 * 144. Binary Tree Preorder Traversal
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author : artairs
 */
class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null){
            return result;
        }

        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }

    /**
     * 方法二，使用非递归方法，模拟一个栈
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Stack<Command> commands = new Stack<>();
        commands.add(new Command(true,root));
        while (!commands.empty()){
            Command command = commands.pop();
            if(command.isPoped){
                if(command.node.right != null) {
                    commands.add(new Command(true, command.node.right));
                }
                if(command.node.left != null) {
                    commands.add(new Command(true, command.node.left));
                }
                commands.add(new Command(false,command.node));
            } else {
                result.add(command.node.val);
            }
        }

        return result;
    }

    private class Command{
        boolean isPoped;
        TreeNode node;

        public Command(boolean isPoped, TreeNode node) {
            this.isPoped = isPoped;
            this.node = node;
        }
    }



}
