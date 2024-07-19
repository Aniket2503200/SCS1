package Thread;

// 27. What is CyclicBarrier and CountDownLatch?

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Question27 {
	public static void main(String[] args) {
		// CountDownLatch example
		int threadCount = 3;
		CountDownLatch latch = new CountDownLatch(threadCount);
		for (int i = 0; i < threadCount; i++) {
			new Thread(new Worker(latch)).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("All threads have finished their work using CountDownLatch");

		// CyclicBarrier example
		int parties = 3;
		CyclicBarrier barrier = new CyclicBarrier(parties,
				() -> System.out.println("All parties have reached the barrier"));

		for (int i = 0; i < parties; i++) {
			new Thread(new Task(barrier)).start();
		}
	}
}

class Worker implements Runnable {
	private final CountDownLatch latch;

	public Worker(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " finished work");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			latch.countDown();
		}
	}
}

class Task implements Runnable {
	private final CyclicBarrier barrier;

	public Task(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
