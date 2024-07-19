package Thread;

// 32. What is synchronized method and synchronized block? Which one should be preferred?

public class Question32 {
	public static void main(String[] args) {
		SyncExample example = new SyncExample();
		Thread t1 = new Thread(example::synchronizedMethod);
		Thread t2 = new Thread(example::synchronizedBlock);

		t1.start();
		t2.start();
	}
}

class SyncExample {
	public synchronized void synchronizedMethod() {
		System.out.println("Synchronized method started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Synchronized method finished");
	}

	public void synchronizedBlock() {
		synchronized (this) {
			System.out.println("Synchronized block started");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Synchronized block finished");
		}
	}
}
