package model;

/**
 * model
 * LeetCode
 * 2019.05.17.20:45
 *
 * @author : artairs
 */
public class LRUCache {

    public class Entry {
        public int key;
        public int value;
        public Entry pre;
        public Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int capacity;
    public int num;
    public Entry head;
    public Entry foot;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (head == null) {
            return -1;
        }
        Entry node = head;
        while (node != null) {
            if (node.key == key) {
                if(num == 1){
                    return node.value;
                }

                if (node == foot) {
                    foot = node.pre;
                    foot.next = null;
                    node.next = head;
                    node.pre = null;
                    head.pre = node;

                    head = node;
                } else if (node != head) {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;

                    node.pre = null;
                    node.next = head;
                    head.pre = node;

                    head = node;
                }
                return node.value;
            }
            node = node.next;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            head.value = value;
        } else {
            Entry node = null;
            if (num == capacity) {
                if(capacity == 1){
                    head.key = key;
                    head.value = value;
                    return;
                }

                node = foot;

                foot = node.pre;
                foot.next = null;

                node.next = null;

                num--;

                node.key = key;
                node.value = value;
            }

            num++;
            if (node == null) {
                node = new Entry(key, value);
            }

            if (head == null) {
                head = node;
                foot = node;
                return;
            }

            node.next = head;
            head.pre = node;
            head = node;
        }
    }
}