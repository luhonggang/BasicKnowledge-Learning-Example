package com.study.synchronizeds;

/**
 * synchronized 普通方法同步,锁是当前实例对象
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/7/23 13:48
 */
public class SynchronizedTest {
    public synchronized void test1(){
        try {
             System.out.println("Method 1 execute");
             Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
         }
            System.out.println("Method 1 end");
    }

    public synchronized void test2(){
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {

        final SynchronizedTest test = new SynchronizedTest();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.test1();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.test2();
                }
            }).start();

    }

}
