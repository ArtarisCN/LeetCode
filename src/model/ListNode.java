package model;

/**
 * Created by RuiL on 2017/7/15.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "this->val = " + String.valueOf(val) + "\n";
    }

}