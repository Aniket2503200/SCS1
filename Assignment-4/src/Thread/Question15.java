package Thread;

// 15. What do you mean by garbage collection?

public class Question15 {
	public static void main(String[] args) {
		// Creating objects
		for (int i = 0; i < 10; i++) {
			new Question15();
		}

		// Explicitly setting objects to null
		for (int i = 0; i < 10; i++) {
			new Question15();
			System.gc(); // Request garbage collection
		}
	}

	// Override finalize method to confirm object deletion
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Garbage Collected");
	}
}
