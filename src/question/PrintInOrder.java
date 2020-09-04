package question;


/**
 * question
 * LeetCode
 * 2020.09.06.下午1:31
 * * <p>
 * 1114. Print in Order
 * https://leetcode.com/problems/print-in-order/
 *
 * @author : rick
 */
public class PrintInOrder {

    class Foo {

        volatile int lock = 0;
        int first = 1<< 1;
        int second = 1<< 2;
        int third = 1<< 3;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            while(lock == 0){
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                lock = lock | first;
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while((lock & first) == 0)
                Thread.sleep(2);
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            lock = lock | second;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while((lock & first) == 0 || (lock & second) == 0)
                Thread.sleep(3);
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}


