package Thread;

// 31. What is busy spinning?

public class Question31 {
	private static volatile boolean flag = false;

	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			while (!flag) {
				// Busy spinning: continuously check the condition without yielding
			}
			System.out.println("Thread 1 finished");
		});

		Thread thread2 = new Thread(() -> {
			try {
				Thread.sleep(2000); // Simulate some work
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag = true; // Set the flag to true to stop thread1's busy spinning
			System.out.println("Thread 2 finished");
		});

		thread1.start();
		thread2.start();
	}
}
