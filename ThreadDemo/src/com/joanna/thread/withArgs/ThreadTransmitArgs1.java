package com.joanna.thread.withArgs;

/**
 * 参数传递（通过构造方法） 
 * author: liu.hj 
 * date: 2017/10/9 
 * copyright wonhigh.net.cn
 */
public class ThreadTransmitArgs1 extends Thread {
	private String name;
	private int age;

	public ThreadTransmitArgs1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void run() {
		System.out.println("hello " + name + ", I am " + age);
	}

	public static void main(String[] args) {
		Thread thread = new ThreadTransmitArgs1("world", 10);
		thread.start();
	}
}
