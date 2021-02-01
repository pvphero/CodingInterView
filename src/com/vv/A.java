package com.vv;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ShenZhenWei
 * @date 2021/1/22
 */
class A {
    private static final ReentrantLock lock = new ReentrantLock();
    private volatile static int i = 0;

    public static void main(String[] args) {
        for (int j = 0; j < 3; j++) {
            final String name = String.valueOf((char) ('A' + j));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (i <= 100) {
                        lock.lock();
                        System.out.println(name + " -> " + ++i);
                        lock.unlock();
                    }
                }
            }).start();
        }
    }

}
