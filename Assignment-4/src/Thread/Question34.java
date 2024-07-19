package Thread;

// 34. What do you mean by the ThreadLocal variable in Java?

public class Question34 {
	private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			threadLocal.set(10);
			System.out.println("Thread-1: " + threadLocal.get());
		});

		Thread t2 = new Thread(() -> {
			threadLocal.set(20);
			System.out.println("Thread-2: " + threadLocal.get());
		});

		t1.start();
		t2.start();
	}
}
