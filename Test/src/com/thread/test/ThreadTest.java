package com.thread.test;

public class ThreadTest extends Thread {
	private ReentrantLockTest reentrantLockTest;
	private String methodName;

	public static void main(String[] args) {
		ReentrantLockTest test = new ReentrantLockTest();
		//ReentrantLockTest test1 = new ReentrantLockTest();
		ThreadTest t1 = new ThreadTest(test, "printA");
		ThreadTest t2 = new ThreadTest(test, "printB");
		t1.start();
		t2.start();
	}

	public ThreadTest(ReentrantLockTest reentrantLockTest, String methodName) {
		super();
		this.reentrantLockTest = reentrantLockTest;
		this.methodName = methodName;
	}

	@Override
	public void run() {
		if ("printA".equalsIgnoreCase(methodName))
			reentrantLockTest.printA();
		else
			reentrantLockTest.printB();
	}

}
