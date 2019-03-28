package delegate;

import java.io.UnsupportedEncodingException;

/**
 * delegate
 * LeetCode
 * 2019.03.19.16:42
 *
 * @author : artairs
 */
public class Customer {

    public static void main(String[] args) throws UnsupportedEncodingException {

        //dynamic
        Sales delegate = new Owner();
        Sales proxy = (Sales) new SalesInvocationHandler().bind(delegate);
        proxy.sell();

        //static
        Sales sales = new Agents();
        sales.sell();
    }



}