package Thread;

// 23. What is Livelock? What happens when it occurs?

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question23 {
	private static Lock lock1 = new ReentrantLock();
	private static Lock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			while (true) {
				if (lock1.tryLock()) {
					System.out.println("Thread 1 acquired lock 1");
					try {
						Thread.sleep(100); // Simulate some work
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (lock2.tryLock()) {
						System.out.println("Thread 1 acquired lock 2");
						lock2.unlock();
						break; // Exit the loop
					} else {
						System.out.println("Thread 1 releasing lock 1");
						lock1.unlock();
					}
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			while (true) {
				if (lock2.tryLock()) {
					System.out.println("Thread 2 acquired lock 2");
					try {
						Thread.sleep(100); // Simulate some work
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (lock1.tryLock()) {
						System.out.println("Thread 2 acquired lock 1");
						lock1.unlock();
						break; // Exit the loop
					} else {
						System.out.println("Thread 2 releasing lock 2");
						lock2.unlock();
					}
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}
