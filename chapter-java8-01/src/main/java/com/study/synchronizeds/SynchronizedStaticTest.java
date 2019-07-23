package com.study.synchronizeds;

/**
 * 静态同步方法，锁是当前类的class对象
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/7/23 13:58
 */
public class SynchronizedStaticTest {

    public static synchronized void test1(){
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public static synchronized void test2(){
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {

        final SynchronizedStaticTest test = new SynchronizedStaticTest();
        final SynchronizedStaticTest test2 = new SynchronizedStaticTest();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.test1();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    test2.test2();
                }
            }).start();
    }

}
