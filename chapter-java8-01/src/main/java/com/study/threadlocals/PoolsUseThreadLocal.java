package com.study.threadlocals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal 的副作用问题
 * 1. 线程复用 会产生脏数据
 *   因线程池 会重用Thread对象, 那么与Thread类 绑定的类的静态属性变量也会被重用
 *   解决方案 : 显示的调用 ThreadLocal 的remove() 方法
 * 2. 内存泄漏问题
 *
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/7/25 10:16
 */
public class PoolsUseThreadLocal {
    public static ThreadLocal<String> localVar = new ThreadLocal<String>();


    public static void main(String[] args) {
        final int INIT_SIZE = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < INIT_SIZE; i++) {
            MyThread thread = new MyThread();
            executorService.execute(thread);
        }

        /*
         *  解决脏数据的问题
         */
        ExecutorService pool = Executors.newFixedThreadPool(1);
        for (int i = 0; i < INIT_SIZE; i++) {
            MyThread02 thread02 = new MyThread02();
            pool.execute(thread02);
        }
    }

    /**
     * 1.产生脏数据的情况
     *  在该线程中,我们没有显示的调用ThreadLocal 的remove() 方法来清理与线程相关的ThreadLocal 信息
     *  导致 另外的线程执行的时候,不去调用set() 设置值,直接去调用get()方法获取值,
     *  结果是 获取到了上一个线程在 ThreadLocal 存的信息 -> "Thread-0 线程的名称没有变化"
     *  这就是 脏数据 问题
     *
     */
    private static class MyThread extends Thread{
        private static  boolean isBreak = true;
        @Override
        public void run() {
            if(isBreak){
                localVar.set(this.getName() +" 线程的名称没有变化");
                isBreak = false;
            }
            System.out.println("线程的名称 = " + localVar.get());
            /**
             * 多线程执行后的结果如下 :
             * 线程的名称 = Thread-0 线程的名称没有变化
             * 线程的名称 = Thread-0 线程的名称没有变化
             */
        }
    }

    /**
     * 解决 脏数据问题,让不同的线程可以拿到属于他们自己 应有的数据
     */
    private static class MyThread02 extends Thread{
        private static  boolean isBreak = true;
        @Override
        public void run() {
            if(isBreak){
                localVar.set(this.getName() +" 线程的名称没有变化");
                isBreak = false;
            }
            System.out.println("线程的名称2 = " + localVar.get());
            /* 每次在线程拿到属于它自己的 数据之后 就清空它的数据, 让其他线程 来继续设置值*/
            localVar.remove();
        }
    }

}
