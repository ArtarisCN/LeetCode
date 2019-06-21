package question;

import java.util.List;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2018.10.16.18:41
 *
 * 112.Path Sum
 * https://leetcode.com/problems/path-sum/
 *
 * @author : artairs
 */
class PathSum {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();



        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null){
            return false;
        }else  if(root.right ==null && root.left == null){
            return sum == root.val;
        } else if(root.right ==null ){
            return hasPathSum2(root.left,sum - root.val);
        } else if(root.left == null){
            return hasPathSum2(root.right,sum - root.val);
        } else {
            return hasPathSum2(root.left,sum - root.val) || hasPathSum2(root.right,sum - root.val);
        }
    }

    public static void findNode(List<Integer> sum,TreeNode node){
        if(node.left == null && node.right == null){
            sum.add(node.val);
            return;
        }

        if(node.left != null){
            node.left.val += node.val;
            findNode(sum,node.left);
        }

        if(node.right != null){
            node.right.val += node.val;
            findNode(sum,node.right);
        }


    }
}
