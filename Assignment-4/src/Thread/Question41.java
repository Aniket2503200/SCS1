package Thread;

// 41. Is it possible that each thread can have its stack in multithreaded programming?

public class Question41 {
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			System.out.println("Thread 1: Starting");
			method1();
			System.out.println("Thread 1: Finished");
		});

		Thread thread2 = new Thread(() -> {
			System.out.println("Thread 2: Starting");
			method1();
			System.out.println("Thread 2: Finished");
		});

		thread1.start();
		thread2.start();
	}

	public static void method1() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": Inside method1");
		method2();
	}

	public static void method2() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + ": Inside method2");
	}
}
