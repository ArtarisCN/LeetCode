package otherQuestion;

import model.TreeNode;

/**
 * otherQuestion
 * LeetCode
 * 2019.05.17.17:44
 *
 * @author : artairs
 */
class FindNodeSumInBinaryTree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


    private static int findNodeSumInBinaryTree(TreeNode root, int n){
        if(n == 0){
            return root != null?1:0;
        }

        return (root.right != null?findNodeSumInBinaryTree(root.right,n - 1):0) + (root.left != null?findNodeSumInBinaryTree(root.left,n - 1):0);
    }

}
