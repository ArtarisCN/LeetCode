package model;

/**
 * model
 * LeetCode
 * 2018.07.11.下午5:58
 *
 * @author : rick
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public void buildTreeNode(TreeNode node,int data){
        if(data < node.val){
            if(node.left == null){
                node.left = new TreeNode(data);
            }else{
                buildTreeNode(node.left,data);
            }
        }else{
            if(node.right == null){
                node.right = new TreeNode(data);
            }else{
                buildTreeNode(node.right,data);
            }
        }
    }

}
