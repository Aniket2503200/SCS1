package Thread;

// 12. What are the benefits of using Multithreading?

public class Question12 {
	public static void main(String[] args) {
		Task7 task = new Task7();

		Thread t1 = new Thread(() -> task.doTask("Thread-1"));
		Thread t2 = new Thread(() -> task.doTask("Thread-2"));

		t1.start();
		t2.start();
	}
}

class Task7 {
	public void doTask(String threadName) {
		System.out.println("Task executed by " + threadName);
		// Simulating some task execution time
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task completed by " + threadName);
	}
}
