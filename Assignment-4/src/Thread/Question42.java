package Thread;

// 42. What is the synchronization process? Why use it?

public class Question42 {
	public static void main(String[] args) {
		SyncExample10 example = new SyncExample10();
		Thread t1 = new Thread(example::syncMethod);
		Thread t2 = new Thread(example::syncMethod);

		t1.start();
		t2.start();
	}
}

class SyncExample10 {
	public synchronized void syncMethod() {
		System.out.println(Thread.currentThread().getName() + " is in synchronized method");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " is leaving synchronized method");
	}
}
