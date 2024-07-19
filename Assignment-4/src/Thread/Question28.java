package Thread;

// 28. What do you mean by inter-thread communication?

public class Question28 {
	public static void main(String[] args) {
		Message message = new Message();

		Thread producerThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				message.produce("Message " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumerThread = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				message.consume();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		producerThread.start();
		consumerThread.start();
	}
}

class Message {
	private String message;
	private boolean empty = true;

	// Producer method
	public synchronized void produce(String message) {
		while (!empty) {
			try {
				wait(); // Wait for consumer to consume
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.message = message;
		empty = false;
		System.out.println("Produced: " + message);
		notifyAll(); // Notify consumer thread that message is ready
	}

	// Consumer method
	public synchronized void consume() {
		while (empty) {
			try {
				wait(); // Wait for producer to produce
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumed: " + message);
		empty = true;
		notifyAll(); // Notify producer thread that message has been consumed
	}
}
