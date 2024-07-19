package Thread;

public class Question1 {
	// 1. What is the start() and run() method of Thread class?

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.start(); // Starts a new thread and calls the run() method internally
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("Running in a separate thread");
	}
}
