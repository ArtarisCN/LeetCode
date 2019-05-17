package question;


import model.LRUCache;
import util.PrintUtils;

/**
 * question
 * LeetCode
 * 2019.05.09.14:05
 * <p>
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 *
 * @author : artairs
 */
class LRUCacheMain {

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        LRUCache cache = new LRUCache(10);

        cache.put(7,28);
        PrintUtils.printCache(cache);

        cache.put(7,1);
        PrintUtils.printCache(cache);

        cache.put(8,15);
        PrintUtils.printCache(cache);

        System.out.println("get 6 = " + cache.get(6));
        PrintUtils.printCache(cache);

        cache.put(10,27);
        PrintUtils.printCache(cache);

        cache.put(8,10);
        PrintUtils.printCache(cache);

        System.out.println("get 8 = " + cache.get(8));
        PrintUtils.printCache(cache);

        cache.put(6,29);
        PrintUtils.printCache(cache);

        cache.put(1,9);
        PrintUtils.printCache(cache);

        System.out.println("get 6 = " + cache.get(6));
        PrintUtils.printCache(cache);

        cache.put(10,7);
//        PrintUtils.printCache(cache);

//        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
//
//        cache.put(1, 1);
//        printCache(cache);
//        cache.put(2, 2);
//        printCache(cache);
//        System.out.println("get = " + cache.get(1));      // 返回  1
//        printCache(cache);
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        printCache(cache);
//        System.out.println("get = " + cache.get(2));      // 返回 -1 (未找到)
//        printCache(cache);
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        printCache(cache);
//        System.out.println("get = " + cache.get(1));      // 返回 -1 (未找到)
//        printCache(cache);
//        System.out.println("get = " + cache.get(3));      // 返回  3
//        printCache(cache);
//        System.out.println("get = " + cache.get(4));      // 返回  4
//        printCache(cache);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }



}
