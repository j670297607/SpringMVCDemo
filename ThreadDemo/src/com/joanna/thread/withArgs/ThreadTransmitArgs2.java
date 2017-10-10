package com.joanna.thread.withArgs;

/**
 * 参数传递（通过set方法，implements Runnable需重写setName方法）
 * author: liu.hj 
 * date: 2017/10/9 
 * copyright wonhigh.net.cn
 */
public class ThreadTransmitArgs2 extends Thread {
	private String name;//extends Thread 不能重写setName
	private int age;

	public void setAge(int age) {
		this.age = age;
	}

	public void run() {
		System.out.println("hello " + name + ", I am " + age);
	}

	public static void main(String[] args) {
		ThreadTransmitArgs2 t2 = new ThreadTransmitArgs2();
		t2.setName("world");
		t2.setAge(10);
		Thread thread = new Thread(t2);
		thread.start();
	}
}