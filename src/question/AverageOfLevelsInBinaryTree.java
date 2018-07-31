package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2018.07.30.23:12
 *
 * 637. Average of Levels in Binary Tree
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 *
 * @author : artaris
 */
class AverageOfLevelsInBinaryTree {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        AverageOfLevelsInBinaryTree tree = new AverageOfLevelsInBinaryTree();

        for (Double aDouble : tree.averageOfLevels(root)) {
            System.out.println(aDouble);
        }


        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }



    public List<Double> averageOfLevels(TreeNode root) {

        Map<Integer,Double> result = new HashMap<>();

        Map<Integer,Integer> nums = new HashMap<>();

        averageOfNode(root,1,result,nums);

        int level = 1;
        List<Double> list = new ArrayList<>();
        while (true){

            list.add(result.get(level)/nums.get(level));

            level ++;
            if(!result.containsKey(level)){
                break;
            }
        }

        return list;

    }

    private void averageOfNode(TreeNode node,int level,Map<Integer,Double> result,Map<Integer,Integer> nums){

        if(node == null)
            return;

        if(result.containsKey(level)){
            result.put(level,((double)node.val + result.get(level)));
            nums.put(level,nums.get(level) + 1);
        } else {
            result.put(level,(double)node.val);
            nums.put(level,1);
        }

        averageOfNode(node.left,level + 1,result,nums);
        averageOfNode(node.right,level + 1,result,nums);

    }
}
