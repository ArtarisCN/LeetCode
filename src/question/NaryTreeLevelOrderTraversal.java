package question;

import java.util.ArrayList;
import java.util.List;

import model.Node;

/**
 * question
 * LeetCode
 * 2018.11.06.14:30
 *
 * 429. N-ary Tree Level Order Traversal
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author : artairs
 */
class NaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();


        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        result.add(temp);
        for (Node child : root.children) {
            levelOrder(result, child, 1);
        }
        return result;
    }

    public static void levelOrder(List<List<Integer>> result, Node root, int index){
        if (root == null) {
            return;
        }

        if(index >= result.size()){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
            for (Node child : root.children) {
                levelOrder(result, child, index + 1);
            }
        } else {
            List<Integer> temp = result.get(index);
            temp.add(root.val);
            for (Node child : root.children) {
                levelOrder(result, child, index + 1);
            }
        }
    }

}
