package question;

import model.TreeNode;

/**
 * question
 * LeetCode
 * 2018.11.06.11:38
 *
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author : artairs
 */
class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

//        sortedArrayToBST(new int[]{-10,-3,0,5,9});
        sortedArrayToBST(new int[]{0,1,2,3,4,5,6,7});

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int element = nums[nums.length/2];
        TreeNode root = new TreeNode(element);
        root.left = buildTree(nums,0,nums.length/2 - 1);
        root.right = buildTree(nums,nums.length/2 + 1,nums.length - 1);
        return root;
    }


    public static TreeNode buildTree(int[] nums,int start,int end){
        if(end - start >= 3){
            int element = nums[(start + end)/2];
            TreeNode root = new TreeNode(element);
            root.left = buildTree(nums,start,(start + end)/2 - 1);
            root.right = buildTree(nums,(start + end)/2 + 1,end);
            return root;
        } else if(end - start == 2){
            TreeNode root = new TreeNode(nums[(start + end)/2]);
            root.left = new TreeNode(nums[start]);
            root.right = new TreeNode(nums[end]);
            return root;
        } else if(end - start == 1){
            TreeNode root = new TreeNode(nums[(start + end)/2]);
            root.right = new TreeNode(nums[end]);
            return root;
        } else if(end < start){
            return null;
        } else {
            return new TreeNode(nums[(start + end)/2]);
        }
    }


}
