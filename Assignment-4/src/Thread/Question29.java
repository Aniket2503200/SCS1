package Thread;

// 29. What is Thread Scheduler and Time Slicing?

public class Question29 {
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 1 - Iteration " + i);
				try {
					Thread.sleep(500); // Simulate some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 2 - Iteration " + i);
				try {
					Thread.sleep(500); // Simulate some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread1.start();
		thread2.start();
	}
}
