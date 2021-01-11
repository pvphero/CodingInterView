package com.vv.singleton;

/**
 * 正确的DCL
 *
 * @author ShenZhenWei
 * @date 2021/1/11
 */
class RightDCLSingleton {
    private volatile static RightDCLSingleton singleton;

    private RightDCLSingleton() {

    }

    public static RightDCLSingleton getInstance() {
        if (singleton == null) {
            synchronized (RightDCLSingleton.class) {
                if (singleton == null) {
                    singleton = new RightDCLSingleton();
                }
            }
        }
        return singleton;
    }
}
