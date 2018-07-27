package question;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2018.07.27.上午11:33
 *
 * 617. Merge Two Binary Trees
 * https://leetcode.com/problems/merge-two-binary-trees/description/
 *
 * @author : rick
 */
class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1 == null){
            return t2;
        }

        if(t2 == null){
            return t1;
        }


        TreeNode treeNode = new TreeNode(t1.val + t2.val);

        treeNode.left = mergeTrees(t1.left,t2.left);
        treeNode.right = mergeTrees(t1.right,t2.right);

        return treeNode;

    }

}
