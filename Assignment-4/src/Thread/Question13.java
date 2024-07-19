package Thread;

// 13. Explain thread pool?

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question13 {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3); // Creating a thread pool with 3 threads

		for (int i = 0; i < 5; i++) {
			Runnable worker = new WorkerThread("Task " + i);
			executor.execute(worker);
		}
		executor.shutdown();
	}
}

class WorkerThread implements Runnable {
	private final String message;

	public WorkerThread(String s) {
		this.message = s;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
		processMessage();
		System.out.println(Thread.currentThread().getName() + " (End)");
	}

	private void processMessage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
