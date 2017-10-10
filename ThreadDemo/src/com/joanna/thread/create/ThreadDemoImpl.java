package com.joanna.thread.create;

/**
 * 类描述
 * author: liu.hj
 * date: 2017/10/9
 * copyright wonhigh.net.cn
 */
public class ThreadDemoImpl implements Runnable {

    private String name;

    public ThreadDemoImpl(String name) {
        this.name = name;
    }

    public void run() {

        long stime = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);

            double rNum = Math.random();
            System.out.println("random num = " + rNum);

            int sleepTime = (int) (rNum * 1000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleepTime = " + sleepTime);
        }
        long etime = System.currentTimeMillis();
        System.out.println((etime - stime));

    }

    public static void main(String[] args) {
        ThreadDemoImpl a = new ThreadDemoImpl("A");
        ThreadDemoImpl b = new ThreadDemoImpl("B");
        new Thread(a).start();
        new Thread(b).start();
    }


}
