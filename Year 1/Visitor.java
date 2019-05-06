package com.oracle;
 
import java.util.Random;
 
class Visitor implements Runnable {
	ThreadExample t;
 
	Visitor(ThreadExample t) {
		this.t = t;
	}
 
	public void run() {
		if (t.getNoOfCars() == 0) {
			synchronized (t) {
				try {
					t.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (t) {
			t.setNoOfCars(t.getNoOfCars() - 1);
			System.out.println(Thread.currentThread().getName()
					+ " is driving, " + t.getNoOfCars() + " car(s) available");
		}
		Random numGen = new Random();
		int r = numGen.nextInt(5000);
		try {
			Thread.sleep(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (t) {
			t.setNoOfCars(t.getNoOfCars() + 1);
			System.out.println(Thread.currentThread().getName()
					+ " has done driving, " + t.getNoOfCars() + " car(s) available");
			t.notify();
		}
	}
}
 
public class ThreadExample {
	private int noOfCars = 3;
 
	public int getNoOfCars() {
		return noOfCars;
	}
 
	public void setNoOfCars(int noOfCars) {
		this.noOfCars = noOfCars;
	}
 
	public static void main(String[] args) {
		ThreadExample t = new ThreadExample();
		System.out.println(t.getNoOfCars() + " cars are available");
		Visitor v1 = new Visitor(t);
		Visitor v2 = new Visitor(t);
		Visitor v3 = new Visitor(t);
		Visitor v4 = new Visitor(t);
		Visitor v5 = new Visitor(t);
		Thread t1 = new Thread(v1, "A");
		Thread t2 = new Thread(v2, "B");
		Thread t3 = new Thread(v3, "C");
		Thread t4 = new Thread(v4, "D");
		Thread t5 = new Thread(v5, "E");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
