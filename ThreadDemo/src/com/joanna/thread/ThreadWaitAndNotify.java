package com.joanna.thread;

/**
 * 类描述
 * author: liu.hj
 * date: 2017/10/9
 * copyright wonhigh.net.cn
 */
public class ThreadWaitAndNotify implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    public ThreadWaitAndNotify(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    public void run() {
        int count = 10;
        while (count>0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count --;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        ThreadWaitAndNotify t1 = new ThreadWaitAndNotify("1",o3, o1);
        ThreadWaitAndNotify t2 = new ThreadWaitAndNotify("2",o1, o2);
        ThreadWaitAndNotify t3 = new ThreadWaitAndNotify("3",o2, o3);

        new Thread(t1).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t2).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t3).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
