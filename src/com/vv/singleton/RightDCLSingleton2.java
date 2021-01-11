package com.vv.singleton;

/**
 * 基于类的初始化的解决方案
 * <p>
 * <p>
 * 了用classloader的机制；来保证初始化instance时只有一个线程。
 * jvm在初始化阶段会获取一个锁，这个锁可以同步多个线程对同一个类的初始化。
 * <p>
 * 这种解决方法的实质是：运行步骤2步骤3重排序，但是不允许被其他线程看见
 * <p>
 * Java语言规定，对于每一个类或者接口C,都有一个唯一的初始化锁LC与之相对应。
 * 从C到LC的映射，由JVM的具体实现去自由实现。JVM在类初始化阶段期间会获取这个初始化锁，并且每一个线程至少获取一次锁来确保这个类已经被初始化过了。
 *
 * @author ShenZhenWei
 * @date 2021/1/11
 */
class RightDCLSingleton2 {
    private static class SingletonHandler {
        public static RightDCLSingleton2 singleton = new RightDCLSingleton2();
    }

    public static RightDCLSingleton2 getInstance() {
        return SingletonHandler.singleton;
    }
}
