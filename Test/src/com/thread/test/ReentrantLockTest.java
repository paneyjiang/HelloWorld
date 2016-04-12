package com.thread.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	
	private static ReentrantLock lock = new ReentrantLock();
	private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
	
	public void printA(){
		lock.lock();
	    System.out.println(format.format(new Date()) + "---printA");
	    try {
	      //TimeUnit.SECONDS.sleep(3);
	    	Thread.currentThread().sleep(1000);
	    	System.out.println("a==============");
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      lock.unlock();
	    }

	}
	
	public void printB(){
		
		lock.lock();
	    System.out.println(format.format(new Date()) + "---printB");
	    try {
	      //TimeUnit.SECONDS.sleep(3);
	      System.out.println("b==============");
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      lock.unlock();
	    }
	}
}
