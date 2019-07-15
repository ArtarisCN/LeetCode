package otherQuestion;

import org.jetbrains.annotations.NotNull;

/**
 * otherQuestion
 * LeetCode
 * 2019.07.09.18:27
 *
 * @author : artairs
 */
class SortDoubleListNode {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int[] array1 = new int[]{1,3,6,2,7,12,9,3,7,1,45};
        int[] array = new int[]{1,3,6,2,7,12,9,3,7,1,45};
//        SortUtils.quickSort(array1);
//        PrintUtils.printfArray(array1);
        Node head = buildDoubleLinkedList(array);
        Node result = sortDoubleList(head);
        System.out.println(result);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    static class Node{
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private static Node sortDoubleList(Node head){
        return _sortDoubleList(head,null);
    }

    private static Node _sortDoubleList(Node start,Node end){
        if(start == null || start == end){
            return start;
        }
        int t = start.val;
        Node i = start,j = start;
        while (j.next != end){
            j = j.next;
        }

        while (i != j){
            while (i != j && j.val >= t){
                j = j.pre;
            }
            while (i != j && i.val <= t){
                i = i.next;
            }

            if(i != j) {
                exchangeNode(i, j);
                Node x = i;
                i = j;
                j = x;
            }
        }

        print(start);
        exchangeNode(i,start);
        print(start);
        System.out.println("----------");

        if(start != i) {
            _sortDoubleList(i, start.pre);
//            _sortDoubleList(start, i.pre);
        }
        if(start.next != null) {
            _sortDoubleList(start.next, null);
//            _sortDoubleList(i.next, null);
        }

        return i;
    }

    private static void exchangeNode(Node node1,Node node2){
        if(node1== null || node2 == null || node1 == node2){
            return;
        }

        Node pre1 = node1.pre;
        Node next1 = node1.next;
        Node pre2 = node2.pre;
        Node next2 = node2.next;

        node2.pre = pre1;
        if(pre1 != null){
            pre1.next = node2;
        }
        node2.next = next1;
        if(next1 != null){
            next1.pre = node2;
        }

        node1.pre = pre2;
        if(pre2 != null){
            pre2.next = node1;
        }
        node1.next = next2;
        if(next2 != null){
            next2.pre = node1;
        }
    }

    public static @NotNull Node buildDoubleLinkedList(int[] array) {
        if(array.length == 0)
            return null;

        Node head = new Node(array[0]);
        Node node = head;

        for (int i = 1; i < array.length; i++) {
            node.next = new Node(array[i]);
            node.next.pre = node;
            node = node.next;
        }

        return head;
    }

    private static void print(Node node){
        Node start = node;
        while(start.pre != null){
            start = start.pre;
        }
        System.out.print(start.val);
        start = start.next;
        while (start != null){
            System.out.print("->"+ start.val);
            start = start.next;
        }
        System.out.println();
    }




}
