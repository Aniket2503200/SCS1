package Thread;

public class Question2 {
	// 2. What is Thread in Java?

	public static void main(String[] args) {
		MyThread1 myThread = new MyThread1();
		myThread.start(); // A thread is a lightweight process, and the start() method initiates a new
							// thread of execution
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		System.out.println("Thread is running");
	}
}
