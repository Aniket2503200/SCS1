package Thread;

// 8. What are the wait() and sleep() methods?

public class Question8 {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			synchronized (Question8.class) {
				try {
					System.out.println("Thread is waiting");
					Question8.class.wait(1000); // Causes the current thread to wait until it is awakened
					System.out.println("Thread is awake");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread.start();

		try {
			Thread.sleep(2000); // Puts the current thread to sleep for 2000 milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (Question8.class) {
			Question8.class.notify(); // Wakes up a single thread that is waiting on the object's monitor
		}
	}
}
