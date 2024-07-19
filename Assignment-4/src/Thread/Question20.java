package Thread;

// 20. What is the purpose of the finalize() method?

public class Question20 {
	public static void main(String[] args) {
		FinalizeExample example = new FinalizeExample();
		example = null;
		System.gc();
		System.out.println("End of main");
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize method called");
	}
}

class FinalizeExample {
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("Finalize method of FinalizeExample called");
	}
}
