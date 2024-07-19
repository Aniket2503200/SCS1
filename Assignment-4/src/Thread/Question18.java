package Thread;

// 18. How do threads communicate with each other?

public class Question18 {
	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource();

		Thread t1 = new Thread(() -> sharedResource.produce());
		Thread t2 = new Thread(() -> sharedResource.consume());

		t1.start();
		t2.start();
	}
}

class SharedResource {
	private int data;
	private boolean available = false;

	public synchronized void produce() {
		try {
			Thread.sleep(1000);
			data = 100;
			available = true;
			notify();
			System.out.println("Produced: " + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void consume() {
		while (!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumed: " + data);
	}
}
