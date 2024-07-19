package Thread;

// 19. Can two threads execute two methods (static and non-static concurrently)?

public class Question19 {
	public static void main(String[] args) {
		Resource resource = new Resource();

		Thread t1 = new Thread(Resource::staticMethod);
		Thread t2 = new Thread(resource::nonStaticMethod);

		t1.start();
		t2.start();
	}
}

class Resource {
	public synchronized static void staticMethod() {
		try {
			Thread.sleep(1000);
			System.out.println("Static method executed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void nonStaticMethod() {
		try {
			Thread.sleep(1000);
			System.out.println("Non-static method executed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
