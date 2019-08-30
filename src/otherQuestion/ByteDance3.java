package otherQuestion;

import model.ListNode;
import util.PrintUtils;
import util.QuestionUtils;

/**
 * otherQuestion
 * LeetCode
 * 2019.08.19.12:56
 *
 * ![](http://img.artaris.cn//blog/img/20190819125625.png)
 * @author : artairs
 */
class ByteDance3 {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();
//        PrintUtils.printf(reverseLinkedList(QuestionUtils.buildLinkedList(new int[]{4,3,2,1})));

        ListNode node = addLinkedNode(QuestionUtils.buildLinkedList(new int[]{9,9,9,9}),QuestionUtils.buildLinkedList(new int[]{1}));
        PrintUtils.printf(node);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static ListNode addLinkedNode(ListNode node1, ListNode node2){
        node1 = reverseLinkedList(node1);
        node2 = reverseLinkedList(node2);

        ListNode listNode,dummy = new ListNode();
        listNode = dummy;

        int carry = 0;
        while (node1 != null && node2 != null){
            int val = node1.val + node2.val + carry;
            if(val >= 10){
                carry = val  / 10;
                val = val % 10;
            } else {
                carry = 0;
            }
            listNode.next = new ListNode(val);
            listNode = listNode.next;
            node1 = node1.next;
            node2 = node2.next;
        }


        if(node1 == null){
            while (node2 != null){
                int val =  node2.val + carry;
                if(val >= 10){
                    carry = val  / 10;
                    val = val %10;
                } else {
                    carry = 0;
                }
                listNode.next = new ListNode(val);
                listNode = listNode.next;
                node2 = node2.next;
            }
        } else {
            while (node1 != null){
                int val =  node1.val + carry;
                if(val >= 10){
                    carry = val  / 10;
                    val = val %10;
                } else {
                    carry = 0;
                }
                listNode.next = new ListNode(val);
                listNode = listNode.next;
                node1 = node1.next;
            }
        }
        if(carry > 0){
            listNode.next = new ListNode(carry);
        }

        return reverseLinkedList(dummy.next);
    }

    private static ListNode reverseLinkedList(ListNode root) {
        ListNode pre = null,node = root,next;
        while (node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
