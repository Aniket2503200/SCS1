package Thread;

// 16. Explain the meaning of the deadlock and when it can occur?

public class Question16 {
	public static void main(String[] args) {
		final String resource1 = "Resource1";
		final String resource2 = "Resource2";

		// Thread-1 locks resource1 and tries to lock resource2
		Thread t1 = new Thread(() -> {
			synchronized (resource1) {
				System.out.println("Thread-1 locked Resource1");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (resource2) {
					System.out.println("Thread-1 locked Resource2");
				}
			}
		});

		// Thread-2 locks resource2 and tries to lock resource1
		Thread t2 = new Thread(() -> {
			synchronized (resource2) {
				System.out.println("Thread-2 locked Resource2");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				synchronized (resource1) {
					System.out.println("Thread-2 locked Resource1");
				}
			}
		});

		t1.start();
		t2.start();
	}
}
