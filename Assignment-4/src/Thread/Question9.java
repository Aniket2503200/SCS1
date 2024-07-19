package Thread;

// 9. What’s the difference between notify() and notifyAll()?

public class Question9 {
	public static void main(String[] args) {
		NotificationDemo demo = new NotificationDemo();

		Thread t1 = new Thread(demo::waitMethod, "Thread-1");
		Thread t2 = new Thread(demo::waitMethod, "Thread-2");
		Thread t3 = new Thread(demo::notifyMethod, "Notifier");

		t1.start();
		t2.start();
		t3.start();
	}
}

class NotificationDemo {
	public synchronized void waitMethod() {
		try {
			System.out.println(Thread.currentThread().getName() + " is waiting");
			wait();
			System.out.println(Thread.currentThread().getName() + " is notified");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void notifyMethod() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " is notifying");
			notify(); // notify() wakes up one waiting thread
			// notifyAll(); // notifyAll() wakes up all waiting threads
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
