package question;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2018.07.20.下午6:17
 *
 *
 * @author : rick
 */
class LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int leftDepth = 1,rightDepth = 1;

        TreeNode pNode = root,qNode = root;


        return p;
    }

    public static int findNodeDepth(TreeNode root, TreeNode p){

        if(root.val == p.val){
            return 1;
        } else if(root.val < p.val){
                return findNodeDepth(root.right,p) + 1;
        } else {
            return findNodeDepth(root.left,p) + 1;
        }

    }



}
