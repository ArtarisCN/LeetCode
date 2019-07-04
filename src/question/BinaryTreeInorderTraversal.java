package question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2019.07.04.14:21
 *
 * 94. Binary Tree Inorder Traversal
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author : artairs
 */
class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private  List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return result;
        }

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

    /**
     * 方法二，使用非递归方法，模拟一个栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
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
                commands.add(new Command(false,command.node));
                if(command.node.left != null) {
                    commands.add(new Command(true, command.node.left));
                }
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
