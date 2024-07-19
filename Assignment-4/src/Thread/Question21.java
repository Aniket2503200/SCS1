package Thread;

import java.util.Hashtable;

// 21. What is ConcurrentHashMap and Hashtable? In java, why is ConcurrentHashMap considered faster than Hashtable?

import java.util.concurrent.ConcurrentHashMap;

public class Question21 {
	public static void main(String[] args) {
		// Hashtable example
		Hashtable<Integer, String> hashtable = new Hashtable<>();
		hashtable.put(1, "One");
		System.out.println("Hashtable: " + hashtable.get(1));

		// ConcurrentHashMap example
		ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put(1, "One");
		System.out.println("ConcurrentHashMap: " + concurrentHashMap.get(1));

		System.out.println(
				"ConcurrentHashMap is considered faster than Hashtable because it uses a finer-grained locking mechanism.");
	}
}
