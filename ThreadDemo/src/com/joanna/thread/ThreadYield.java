package com.joanna.thread;

/**
 * yield 线程退让
 * author: liu.hj
 * date: 2017/10/9
 * copyright wonhigh.net.cn
 */
public class ThreadYield extends Thread {

    public ThreadYield(String name) {
        super(name);
    }

    public void run() {
        for(int i=0;i<50;i++) {
            System.out.println(this.getName() + "-----" + i);
            if(i % 3 == 0) {
                System.out.println(this.getName()+" yield~~~");
                this.yield();
                // 当i为3时，该线程就会把CPU时间让掉，让其他或者自己的线程执行（也就是谁先抢到谁执行）
            }
        }
    }

    public static void main(String[] args) {
        ThreadYield a = new ThreadYield("A");
        ThreadYield b = new ThreadYield("B");
        a.start();
        b.start();
    }
}
