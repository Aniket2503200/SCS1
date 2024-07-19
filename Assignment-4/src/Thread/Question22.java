package Thread;

// 22. What is thread starvation?

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question22 {
	private static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			lock.lock();
			try {
				System.out.println("Thread 1 acquired the lock");
				Thread.sleep(2000); // Simulate some work
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		});

		Thread thread2 = new Thread(() -> {
			// Attempting to acquire the lock but might starve if thread1 keeps holding the
			// lock
			lock.lock();
			try {
				System.out.println("Thread 2 acquired the lock");
			} finally {
				lock.unlock();
			}
		});

		thread1.start();
		thread2.start();
	}
}
