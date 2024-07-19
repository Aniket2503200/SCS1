package Thread;

// 36. Explain Thread Group. Why should we not use it?

public class Question36 {
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("Example Group");
		Thread t1 = new Thread(group, () -> System.out.println("Thread-1 executed"), "Thread-1");
		Thread t2 = new Thread(group, () -> System.out.println("Thread-2 executed"), "Thread-2");

		t1.start();
		t2.start();

		System.out.println("Thread Group Name: " + group.getName());
		group.list();

		System.out.println(
				"Thread Group is considered deprecated and not recommended because it lacks flexibility and does not provide necessary control over threads.");
	}
}
