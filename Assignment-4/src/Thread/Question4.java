package Thread;

// 4. What's the difference between thread and process?

public class Question4 {
	public static void main(String[] args) {
		// Creating and starting multiple threads within the same Java process
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 1: " + i);
				try {
					Thread.sleep(500); // Simulate some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 2: " + i);
				try {
					Thread.sleep(500); // Simulate some work
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Starting the threads
		thread1.start();
		thread2.start();

		// Main process continues its execution
		for (int i = 0; i < 5; i++) {
			System.out.println("Main process: " + i);
			try {
				Thread.sleep(500); // Simulate some work
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
