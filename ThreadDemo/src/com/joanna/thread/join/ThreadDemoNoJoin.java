package com.joanna.thread.join;

/**
 * 类描述
 * author: liu.hj
 * date: 2017/10/9
 * copyright wonhigh.net.cn
 */
public class ThreadDemoNoJoin extends Thread {
    private String name;

    public ThreadDemoNoJoin(String name) {
        super(name);
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + name + "运行 : " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
        ThreadDemoNoJoin mTh1 = new ThreadDemoNoJoin("A");
        ThreadDemoNoJoin mTh2 = new ThreadDemoNoJoin("B");
        mTh1.start();
        mTh2.start();
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");

    }
}
