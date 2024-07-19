package Thread;

// 35. What is semaphore?

import java.util.concurrent.Semaphore;

public class Question35 {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);

		Thread t1 = new Thread(new SemaphoreWorker(semaphore));
		Thread t2 = new Thread(new SemaphoreWorker(semaphore));

		t1.start();
		t2.start();
	}
}

class SemaphoreWorker implements Runnable {
	private final Semaphore semaphore;

	public SemaphoreWorker(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " is waiting for a permit");
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " gets a permit");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " releases the permit");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
