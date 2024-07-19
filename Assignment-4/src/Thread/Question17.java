package Thread;

// 17. Explain volatile variables in Java?

public class Question17 {
	private volatile boolean flag = true;

	public static void main(String[] args) {
		Question17 example = new Question17();

		Thread t1 = new Thread(example::runMethod);
		t1.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		example.flag = false; // Changing the value of volatile variable
		System.out.println("Flag is set to false");
	}

	public void runMethod() {
		while (flag) {
			// The loop will exit when flag becomes false
		}
		System.out.println("Thread terminated");
	}
}
