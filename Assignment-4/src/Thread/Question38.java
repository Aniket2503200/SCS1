package Thread;

// 38. What will happen if we don’t override the thread class run() method?

public class Question38 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread6());
		t1.start();
	}
}

class MyThread6 extends Thread {
	// No run() method overridden
}
