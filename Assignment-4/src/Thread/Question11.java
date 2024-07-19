package Thread;

// 11. What is Runnable and Callable Interface? Write the difference between them.

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Question11 {
	public static void main(String[] args) {
		// Using Runnable
		Runnable runnableTask = () -> System.out.println("Runnable task executed");
		Thread thread = new Thread(runnableTask);
		thread.start();

		// Using Callable
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Callable<String> callableTask = () -> "Callable task executed";
		Future<String> future = executor.submit(callableTask);
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
	}
}
