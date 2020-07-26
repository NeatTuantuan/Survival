package 并发多线程.生产者消费者;

/**
 * @ClassName test
 * @Description TODO
 * @Author tuantuan
 * @Date 2020/7/26 上午11:18
 * @Version 1.0
 * @Attention Copyright (C), 2004-2019, BDILab, XiDian University
 **/
public class test {
    private static int count = 0;
    private static final int FULL = 10;
    private static Object lock = new Object();
    public static void main(String[] args) {
        test test = new test();
        new Thread(test.new Producer()).start();
        new Thread(test.new Comsumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Comsumer()).start();

    }

    class Producer implements Runnable{
        @Override
        public void run() {
            for (int i = 0 ; i < 5 ; i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock){
                    while(count == FULL){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者生产，共有"+count);
                    lock.notifyAll();
                }
            }


        }
    }

    class Comsumer implements Runnable{
        @Override
        public void run() {
            for (int i = 0 ; i < 5 ; i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock){
                    while(count == FULL){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者消费，共有"+count);
                    lock.notifyAll();
                }

            }
        }
    }
}


