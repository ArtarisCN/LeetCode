package delegate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * delegate
 * LeetCode
 * 2019.03.19.16:37
 *
 * @author : artairs
 */
public class SalesInvocationHandler implements InvocationHandler{
    //代理类持有一个委托类的对象引用
    private Object delegate;
    /**
     * 绑定委托对象并返回一个代理类
     * @param delegate
     * @return
     */
    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println(proxy.getClass().getInterfaces()[0]);
        System.out.println("Enter method "+method.getName());
        long start=System.currentTimeMillis();

        Object result=method.invoke(delegate, args);

        long end=System.currentTimeMillis();
        System.out.println("Exit method "+method.getName());
        System.out.println("执行时间："+(end-start));

        return result;
    }
}

