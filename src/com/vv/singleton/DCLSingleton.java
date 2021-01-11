package com.vv.singleton;

/**
 * 双重检查 DCL 是有问题的
 *
 * @author ShenZhenWei
 * @date 2021/1/11
 */
public class DCLSingleton {
    private static DCLSingleton singleton;

    public DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (singleton == null) {
            synchronized (DCLSingleton.class) {
                if (singleton == null) {
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }
}
/**
 * 创建类的过程
 * 1.分配内存空间
 * 2.初始化对象
 * 3.将内存空间的地址赋值给对应的引用
 * <p>
 * 2，3可能会发生重排序
 */
