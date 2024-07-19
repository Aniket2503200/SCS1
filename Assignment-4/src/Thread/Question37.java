package Thread;

// 37. What is the ExecutorService interface?

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Question37 {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			executorService.submit(new Task1());
		}

		executorService.shutdown();
	}
}

class Task1 implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is executing task");
	}
}
