package Thread;

// 25. Can you start a thread twice?

public class Question25 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> System.out.println("Thread executed"));
		t1.start();

		// Uncommenting the following line will throw IllegalThreadStateException
		// t1.start();
	}
}
