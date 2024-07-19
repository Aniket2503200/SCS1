package Thread;

// 10. Why wait(), notify(), and notifyAll() methods are present in Object class?

public class Question10 {
	public static void main(String[] args) {
		SharedResource11 sharedResource = new SharedResource11();

		Thread producer = new Thread(() -> sharedResource.produce());
		Thread consumer = new Thread(() -> sharedResource.consume());

		producer.start();
		consumer.start();
	}
}

class SharedResource11 {
	private int data;
	private boolean available = false;

	public synchronized void produce() {
		try {
			System.out.println("Producer is producing data...");
			Thread.sleep(1000);
			data = 100;
			available = true;
			notify(); // Notify the consumer thread
			System.out.println("Produced: " + data);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void consume() {
		while (!available) {
			try {
				System.out.println("Consumer is waiting for data...");
				wait(); // Wait for the producer to produce data
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumed: " + data);
	}
}
