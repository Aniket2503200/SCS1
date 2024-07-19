package Thread;

// 39. What is the lock interface? Why is it better to use a lock interface rather than a synchronized block?

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question39 {
	public static void main(String[] args) {
		LockExample example = new LockExample();

		Thread t1 = new Thread(example::lockMethod);
		Thread t2 = new Thread(example::lockMethod);

		t1.start();
		t2.start();
	}
}

class LockExample {
	private final Lock lock = new ReentrantLock();

	public void lockMethod() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " is executing");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
