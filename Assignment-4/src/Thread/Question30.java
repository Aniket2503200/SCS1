package Thread;

// 30. What is a shutdown hook?

public class Question30 {
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Shutdown hook executed");
		}));

		System.out.println("Main thread is sleeping for 2 seconds");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread is exiting");
	}
}
