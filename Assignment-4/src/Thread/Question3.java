package Thread;

// 3. What are the two ways of implementing thread in Java?

public class Question3 {
	public static void main(String[] args) {
		// Way 1: By extending the Thread class
		MyThread2 myThread = new MyThread2();
		myThread.start();

		// Way 2: By implementing the Runnable interface
		Thread thread = new Thread(new MyRunnable());
		thread.start();
	}
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		System.out.println("Thread is running by extending Thread class");
	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("Thread is running by implementing Runnable interface");
	}
}
