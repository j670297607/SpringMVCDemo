package com.joanna.thread.withArgs;

import java.util.Random;

/**
 * 使用回调函数
 * author: liu.hj
 * date: 2017/10/9
 * copyright wonhigh.net.cn
 */
public class ThreadTransmitArgs3 extends Thread {
    private Work work;

    public ThreadTransmitArgs3(Work work) {
        this.work = work;
    }

    public void run() {
        Random random = new Random();
        int n1 = random.nextInt(1000);
        int n2 = random.nextInt(2000);
        int n3 = random.nextInt(3000);
        int sum = work.process(n1, n2, n3); // 使用回调函数
        System.out.println(n1 + "+" + n2 + "+" + n3 + "=" + sum);
    }

    public static void main(String[] args) {
        Thread thread = new ThreadTransmitArgs3(new Work());
        thread.start();
    }
}

class Work {
    public int process(Integer...numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }
}

