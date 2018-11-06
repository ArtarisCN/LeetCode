package model;

import java.util.List;

/**
 * model
 * LeetCode
 * 2018.11.06.14:33
 *
 * @author : artairs
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
