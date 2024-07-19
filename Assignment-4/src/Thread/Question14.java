package Thread;

// 14. What’s the purpose of the join() method?

public class Question14 {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(2000);
				System.out.println("Thread-1 completed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
				System.out.println("Thread-2 completed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join(); // Waits for t1 to die
			t2.join(); // Waits for t2 to die
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main thread completed");
	}
}
