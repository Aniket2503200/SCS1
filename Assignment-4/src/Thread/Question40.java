package Thread;

// 40. Is it possible to call the run() method directly to start a new thread?

public class Question40 {
	public static void main(String[] args) {
		MyThread7 t1 = new MyThread7();
		t1.run(); // This will not start a new thread
		t1.start(); // This will start a new thread
	}
}

class MyThread7 extends Thread {
	@Override
	public void run() {
		System.out.println("Thread is running");
	}
}
