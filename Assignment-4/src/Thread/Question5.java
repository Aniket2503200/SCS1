package Thread;

// 5. What’s the difference between class lock and object lock?

public class Question5 {
	public static void main(String[] args) {
		// Example to illustrate class lock and object lock
		ClassLockExample classLockExample = new ClassLockExample();
		ObjectLockExample objectLockExample1 = new ObjectLockExample();
		ObjectLockExample objectLockExample2 = new ObjectLockExample();

		Thread t1 = new Thread(() -> classLockExample.classLockMethod());
		Thread t2 = new Thread(() -> classLockExample.classLockMethod());
		Thread t3 = new Thread(() -> objectLockExample1.objectLockMethod());
		Thread t4 = new Thread(() -> objectLockExample2.objectLockMethod());

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class ClassLockExample {
	public static synchronized void classLockMethod() {
		System.out.println("Class lock method");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ObjectLockExample {
	public synchronized void objectLockMethod() {
		System.out.println("Object lock method");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
