package Thread;

// 7. How can we create daemon threads?

public class Question7 {
	public static void main(String[] args) {
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
		daemonThread.setDaemon(true); // Setting thread as daemon
		daemonThread.start();
	}
}
