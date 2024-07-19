package Thread;

// 6. What's the difference between User thread and Daemon thread?

public class Question6 {
	public static void main(String[] args) {
		Thread userThread = new Thread(() -> {
			try {
				Thread.sleep(2000);
				System.out.println("User thread finished");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread daemonThread = new Thread(() -> {
			while (true) {
				System.out.println("Daemon thread running");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		daemonThread.setDaemon(true);

		userThread.start();
		daemonThread.start();
	}
}
