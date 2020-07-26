package 并发多线程.两个线程交替打印;

/**
 * @ClassName ThreadPrint
 * @Description 两个线程交替打印数，一个只打印奇数一个只打印偶数
 * @Author tuantuan
 * @Date 2020/2/21 上午11:36
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class ThreadPrint {

    private static volatile int i = 1;

    public static void main(String[] args) throws Exception {
        final Object lock = new Object();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    for (; i < 11; ) {
                        System.out.println(Thread.currentThread().getName() + " " + (i++));
                        try {
                            lock.notifyAll();
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
//                        lock.notifyAll();
                }
            }
        };

        Thread t1 = new Thread(runnable, "打印偶数的线程 ");
        Thread t2 = new Thread(runnable, "打印奇数的线程 ");
        t2.start();
        t1.start();
    }
}
